/*-
 * ==========================LICENSE_START=================================
 * Trinity Scaffolder for Java Applications
 * ========================================================================
 * Copyright (C) 2019 - 2020 Christos Tsakostas, OREGOR
 * ========================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ===========================LICENSE_END==================================
 */

package ${ projectDescription.groupId };

import ${ projectDescription.groupId }.testcontainers.ActiveMqContainer;
import io.cucumber.spring.CucumberContextConfiguration;
import java.time.Duration;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.ClassRule;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.containers.wait.strategy.Wait;

/**
 * The type Cucumber integration test.
 *
 * @author Christos Tsakostas
 */
@CucumberContextConfiguration
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration(
    classes = Application.class,
    loader = SpringBootContextLoader.class,
    initializers = CucumberIntegrationTest.Initializer.class)
@Slf4j
@Data
public abstract class CucumberIntegrationTest {

  // ===============================================================================================
  // PROTECTED FIELDS
  // ===============================================================================================

  /**
   * The Rest template.
   */
  protected RestTemplate restTemplate = new RestTemplate();

  /**
   * The Default url.
   */
  protected final String DEFAULT_URL = "http://localhost:8080";

  // ===============================================================================================
  // PROTECTED REPOSITORIES & CONVERTERS
  // ===============================================================================================

  // ===============================================================================================
  // SHARED FIELDS
  // ===============================================================================================

  private String jwtTokenAdmin;
  private String jwtTokenUser1;
  private String jwtTokenUser2;
  private String jwtTokenUser3;

  private String userIdAdmin;
  private String userIdUser1;
  private String userIdUser2;
  private String userIdUser3;

  // ===============================================================================================
  // STATIC INITIALIZATION
  // ===============================================================================================

  private static final String DOCKER_IMAGE_ACTIVEMQ = "rmohr/activemq:5.15.9";
  private static final String DOCKER_IMAGE_MARIADB = "mariadb:10.4.14";
  private static final Integer MARIADB_PORT = 3306;
  private static final long WAITING_TIME_FOR_CONTAINER_STARTUP_IN_SEC = 90;

  @ClassRule
  static ActiveMqContainer activeMqContainer = new ActiveMqContainer(DOCKER_IMAGE_ACTIVEMQ);

  @ClassRule
  static MariaDBContainer<?> mariaDbContainer = new MariaDBContainer<>(DOCKER_IMAGE_MARIADB);

  static class Initializer
      implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    // =============================================================================================
    // OVERRIDES
    // =============================================================================================

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
      initializeActiveMq(configurableApplicationContext);
      initializeMariaDb(configurableApplicationContext);
    }

    // =============================================================================================
    // PRIVATE
    // =============================================================================================

    private void initializeActiveMq(ConfigurableApplicationContext configurableApplicationContext) {
      activeMqContainer.withStartupTimeout(
          Duration.ofSeconds(WAITING_TIME_FOR_CONTAINER_STARTUP_IN_SEC));
      activeMqContainer.withClasspathResourceMapping(
          "/activemq/conf/activemq.xml", "/opt/activemq/conf/activemq.xml", BindMode.READ_WRITE);
      activeMqContainer.waitingFor(Wait.forListeningPort());
      activeMqContainer.start();
      LOG.info(
          "ActiveMq listening at IP={} and port={}",
          activeMqContainer.getContainerIpAddress(),
          activeMqContainer.getMappedPort(activeMqContainer.getActivemqPort()));

      TestPropertyValues.of(
          "camel.component.activemq.broker-u-r-l=tcp://localhost:"
              + activeMqContainer.getMappedPort(activeMqContainer.getActivemqPort()))
          .applyTo(configurableApplicationContext.getEnvironment());
    }

    private void initializeMariaDb(ConfigurableApplicationContext configurableApplicationContext) {
      mariaDbContainer.withStartupTimeout(
          Duration.ofSeconds(WAITING_TIME_FOR_CONTAINER_STARTUP_IN_SEC));
      mariaDbContainer.waitingFor(Wait.forListeningPort());
      mariaDbContainer.start();
      LOG.info(
          "MariaDb listening at IP={} and port={}",
          mariaDbContainer.getContainerIpAddress(),
          mariaDbContainer.getMappedPort(MARIADB_PORT));

      TestPropertyValues.of(
          "spring.datasource.url=" + mariaDbContainer.getJdbcUrl(),
          "spring.datasource.username=" + mariaDbContainer.getUsername(),
          "spring.datasource.password=" + mariaDbContainer.getPassword())
          .applyTo(configurableApplicationContext.getEnvironment());
    }
  }

  // ===============================================================================================
  // PROTECTED
  // ===============================================================================================

  // ===============================================================================================
  // PRIVATE
  // ===============================================================================================

  private MultiValueMap<String, String> getHeaders(String jwtToken) {
    MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
    headers.add("Content-Type", "application/json");
    headers.add("Authorization", String.format("Bearer %s", jwtToken));
    return headers;
  }
}
