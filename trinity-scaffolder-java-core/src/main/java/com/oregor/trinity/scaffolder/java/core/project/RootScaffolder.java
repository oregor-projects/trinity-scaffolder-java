/*-
 * ==========================LICENSE_START=================================
 * Trinity Scaffolder for Java Applications
 * ========================================================================
 * Copyright (C) 2019 Christos Tsakostas, OREGOR LP
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

package com.oregor.trinity.scaffolder.java.core.project;

import com.oregor.trinity.scaffolder.java.core.AbstractProjectScaffolder;
import com.oregor.trinity.scaffolder.java.core.ProjectDescription;
import com.oregor.trinity.scaffolder.java.freemarker.FreemarkerService;
import com.oregor.trinity.scaffolder.java.path.PathService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

/**
 * The type Root scaffolder.
 *
 * @author Christos Tsakostas
 */
public class RootScaffolder extends AbstractProjectScaffolder {

  private static final String FTL_ROOT_PATH =
      Paths.get("/ftl", "trinity-scaffolder-java").toString();
  private static final String FTL_DEV_PATH = Paths.get(FTL_ROOT_PATH, ".dev").toString();
  private static final String FTL_ACTIVEMQ_CONF_PATH =
      Paths.get(FTL_DEV_PATH, "activemq", "conf").toString();

  private static final String DEV_PATH = Paths.get(".dev").toString();
  private static final String DEV_MARIADB_INIT_PATH =
      Paths.get(DEV_PATH, "mariadb", "init").toString();
  private static final String DEV_ACTIVEMQ_CONF_PATH =
      Paths.get(DEV_PATH, "activemq", "conf").toString();

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Root scaffolder.
   *
   * @param freemarkerService the freemarker service
   */
  public RootScaffolder(FreemarkerService freemarkerService) {
    super(freemarkerService);
  }

  // ===============================================================================================
  // BEHAVIOUR
  // ===============================================================================================

  @Override
  public void scaffold(
      Path generationPath, ProjectDescription projectDescription, Map<String, Object> dataModel) {

    copyDevFolder(generationPath, dataModel);
    copyDevMariaDbInitFolder(generationPath, dataModel);
    copyDevActiveMqConfFolder(generationPath, projectDescription, dataModel);
    copyRunScripts(generationPath);

    try {
      PathService.ensurePath(Paths.get(generationPath.toString(), ".mvn/wrapper/"));

      Path targetMvnw = Paths.get(generationPath.toString(), "mvnw");
      if (!targetMvnw.toFile().exists()) {
        Files.copy(
            getClass().getResourceAsStream(FTL_ROOT_PATH + "/mvnw"),
            targetMvnw,
            StandardCopyOption.REPLACE_EXISTING);
      }

      Path targetMvnwCmd = Paths.get(generationPath.toString(), "mvnw.cmd");
      if (!targetMvnwCmd.toFile().exists()) {
        Files.copy(
            getClass().getResourceAsStream(FTL_ROOT_PATH + "/mvnw.cmd"),
            targetMvnwCmd,
            StandardCopyOption.REPLACE_EXISTING);
      }

      Files.copy(
          getClass().getResourceAsStream(FTL_ROOT_PATH + "/.mvn/wrapper/maven-wrapper.jar"),
          Paths.get(generationPath.toString(), ".mvn/wrapper/maven-wrapper.jar"),
          StandardCopyOption.REPLACE_EXISTING);

      Files.copy(
          getClass().getResourceAsStream(FTL_ROOT_PATH + "/.mvn/wrapper/maven-wrapper.properties"),
          Paths.get(generationPath.toString(), ".mvn/wrapper/maven-wrapper.properties"),
          StandardCopyOption.REPLACE_EXISTING);

      Files.copy(
          getClass().getResourceAsStream(FTL_ROOT_PATH + "/lombok.config"),
          Paths.get(generationPath.toString(), "lombok.config"),
          StandardCopyOption.REPLACE_EXISTING);

    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }
  }

  // ===============================================================================================
  // PRIVATE
  // ===============================================================================================

  private void copyDevFolder(Path generationPath, Map<String, Object> dataModel) {
    Path devPath = Paths.get(generationPath.toString(), DEV_PATH);
    PathService.ensurePath(devPath);

    try {
      Path targetEnv = Paths.get(devPath.toString(), ".env");
      if (!targetEnv.toFile().exists()) {
        freemarkerService.exportIfNotExists(
            dataModel, "trinity-scaffolder-java/.dev/.env.ftl", targetEnv);
      }

      Path targetDockerCompose = Paths.get(devPath.toString(), "docker-compose.yaml");
      if (!targetDockerCompose.toFile().exists()) {
        Files.copy(
            getClass().getResourceAsStream(FTL_DEV_PATH + "/docker-compose.yaml"),
            targetDockerCompose,
            StandardCopyOption.REPLACE_EXISTING);
      }

      Path targetDockerStart = Paths.get(devPath.toString(), "docker-start.sh");
      if (!targetDockerStart.toFile().exists()) {
        Files.copy(
            getClass().getResourceAsStream(FTL_DEV_PATH + "/docker-start.sh"),
            targetDockerStart,
            StandardCopyOption.REPLACE_EXISTING);
      }

      Path targetDockerStop = Paths.get(devPath.toString(), "docker-stop.sh");
      if (!targetDockerStop.toFile().exists()) {
        Files.copy(
            getClass().getResourceAsStream(FTL_DEV_PATH + "/docker-stop.sh"),
            targetDockerStop,
            StandardCopyOption.REPLACE_EXISTING);
      }

      Path targetReadme = Paths.get(devPath.toString(), "README.md");
      if (!targetReadme.toFile().exists()) {
        Files.copy(
            getClass().getResourceAsStream(FTL_DEV_PATH + "/README.md"),
            targetReadme,
            StandardCopyOption.REPLACE_EXISTING);
      }
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }
  }

  private void copyDevMariaDbInitFolder(Path generationPath, Map<String, Object> dataModel) {
    Path devMariaDbInitPath = Paths.get(generationPath.toString(), DEV_MARIADB_INIT_PATH);
    PathService.ensurePath(devMariaDbInitPath);

    Path target = Paths.get(devMariaDbInitPath.toString(), "01.sql");
    if (!target.toFile().exists()) {
      freemarkerService.exportIfNotExists(
          dataModel, "trinity-scaffolder-java/.dev/mariadb/init/01.sql.ftl", target);
    }
  }

  private void copyDevActiveMqConfFolder(
      Path generationPath, ProjectDescription projectDescription, Map<String, Object> dataModel) {
    Path devActiveMqConfPath = Paths.get(generationPath.toString(), DEV_ACTIVEMQ_CONF_PATH);
    PathService.ensurePath(devActiveMqConfPath);

    Path target = Paths.get(devActiveMqConfPath.toString(), "activemq.xml");
    if (!target.toFile().exists()) {
      freemarkerService.exportIfNotExists(
          dataModel, "trinity-scaffolder-java/.dev/activemq/conf/activemq.xml.ftl", target);
    }

    // COPY TO APP TEST RESOURCES
    Path modulePath =
        Paths.get(generationPath.toString(), projectDescription.getModulePrefix() + "app");

    PathService.ensurePath(Paths.get(modulePath.toString(), "src/test/resources/activemq/conf"));

    try {
      Files.copy(
          target,
          Paths.get(modulePath.toString(), "src/test/resources/activemq/conf", "activemq.xml"),
          StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }

    try {
      String[] files = {
        "broker-localhost.cert",
        "broker.ks",
        "broker.ts",
        "client.ks",
        "client.ts",
        "credentials-enc.properties",
        "credentials.properties",
        "groups.properties",
        "java.security",
        "jetty-realm.properties",
        "jetty.xml",
        "jmx.access",
        "jmx.password",
        "log4j.properties",
        "logging.properties",
        "login.config",
        "users.properties",
      };

      for (String file : files) {
        target = Paths.get(devActiveMqConfPath.toString(), file);
        if (!target.toFile().exists()) {
          Files.copy(
              getClass().getResourceAsStream(FTL_ACTIVEMQ_CONF_PATH + "/" + file),
              target,
              StandardCopyOption.REPLACE_EXISTING);
        }
      }
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }
  }

  private void copyRunScripts(Path generationPath) {
    PathService.ensurePath(Paths.get(generationPath.toString()));

    try {
      Path runGenerateOpenapi = Paths.get(generationPath.toString(), "run-generate-openapi.sh");
      if (!runGenerateOpenapi.toFile().exists()) {
        Files.copy(
            getClass().getResourceAsStream(FTL_ROOT_PATH + "/run-generate-openapi.sh"),
            runGenerateOpenapi,
            StandardCopyOption.REPLACE_EXISTING);
      }

      Path runIntegrationTests = Paths.get(generationPath.toString(), "run-integration-tests.sh");
      if (!runIntegrationTests.toFile().exists()) {
        Files.copy(
            getClass().getResourceAsStream(FTL_ROOT_PATH + "/run-integration-tests.sh"),
            runIntegrationTests,
            StandardCopyOption.REPLACE_EXISTING);
      }

      Path runPrepareToCommit = Paths.get(generationPath.toString(), "run-prepare-to-commit.sh");
      if (!runPrepareToCommit.toFile().exists()) {
        Files.copy(
            getClass().getResourceAsStream(FTL_ROOT_PATH + "/run-prepare-to-commit.sh"),
            runPrepareToCommit,
            StandardCopyOption.REPLACE_EXISTING);
      }

      Path runSonar = Paths.get(generationPath.toString(), "run-sonar.sh");
      if (!runSonar.toFile().exists()) {
        Files.copy(
            getClass().getResourceAsStream(FTL_ROOT_PATH + "/run-sonar.sh"),
            runSonar,
            StandardCopyOption.REPLACE_EXISTING);
      }

      Path runUnitTests = Paths.get(generationPath.toString(), "run-unit-tests.sh");
      if (!runUnitTests.toFile().exists()) {
        Files.copy(
            getClass().getResourceAsStream(FTL_ROOT_PATH + "/run-unit-tests.sh"),
            runUnitTests,
            StandardCopyOption.REPLACE_EXISTING);
      }

    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }
  }
}
