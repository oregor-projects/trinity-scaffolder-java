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

package com.oregor.trinity.scaffolder.java.core.app;

import com.oregor.trinity.scaffolder.java.core.AbstractProjectScaffolder;
import com.oregor.trinity.scaffolder.java.core.AppConfigLocationType;
import com.oregor.trinity.scaffolder.java.core.ProjectDescription;
import com.oregor.trinity.scaffolder.java.freemarker.FreemarkerService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

/**
 * The type App scaffolder.
 *
 * @author Christos Tsakostas
 */
public class AppScaffolder extends AbstractProjectScaffolder {

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new App scaffolder.
   *
   * @param freemarkerService the freemarker service
   */
  public AppScaffolder(FreemarkerService freemarkerService) {
    super(freemarkerService);
  }

  // ===============================================================================================
  // BEHAVIOUR
  // ===============================================================================================

  @Override
  public void scaffold(
      Path generationPath, ProjectDescription projectDescription, Map<String, Object> dataModel) {

    Path modulePath =
        Paths.get(generationPath.toString(), projectDescription.getModulePrefix() + "app");

    ensureSources(modulePath, projectDescription);

    exportApplicationYml(modulePath, dataModel);

    exportConfigApplicationDevYml(
        projectDescription.getAppConfigLocationType(), modulePath, dataModel);

    exportConfigApplicationCiYml(
        projectDescription.getAppConfigLocationType(), modulePath, dataModel);

    exportTest(projectDescription, modulePath, dataModel);

    exportJavaActuator(projectDescription, modulePath, dataModel);
    exportJavaConfigRestTemplate(projectDescription, modulePath, dataModel);
    exportJavaConfigSpringDoc(projectDescription, modulePath, dataModel);

    freemarkerService.exportIfNotExists(
        dataModel,
        "trinity-scaffolder-java/app/pom.xml.ftl",
        Paths.get(modulePath.toString(), "pom.xml"));

    freemarkerService.exportIfNotExists(
        dataModel,
        "trinity-scaffolder-java/app/Application.java.ftl",
        Paths.get(
            modulePath.toString(),
            "src/main/java",
            toPath(projectDescription.getGroupId()),
            "Application.java"));

    freemarkerService.exportIfNotExists(
        dataModel,
        "trinity-scaffolder-java/app/ApplicationTest.java.ftl",
        Paths.get(
            modulePath.toString(),
            "src/test/java",
            toPath(projectDescription.getGroupId()),
            "ApplicationTest.java"));
  }
  // ===============================================================================================
  // PRIVATE
  // ===============================================================================================

  private void exportJavaConfigRestTemplate(
      ProjectDescription projectDescription, Path modulePath, Map<String, Object> dataModel) {
    freemarkerService.exportIfNotExists(
        dataModel,
        "trinity-scaffolder-java/app/src/main/java/config/resttemplate/"
            + "RestTemplateConfiguration.java.ftl",
        Paths.get(
            modulePath.toString(),
            "src/main/java",
            toPath(projectDescription.getGroupId()),
            "config",
            "resttemplate",
            "RestTemplateConfiguration.java"));
  }

  private void exportJavaConfigSpringDoc(
      ProjectDescription projectDescription, Path modulePath, Map<String, Object> dataModel) {
    freemarkerService.exportIfNotExists(
        dataModel,
        "trinity-scaffolder-java/app/src/main/java/config/springdoc/"
            + "SpringDocConfiguration.java.ftl",
        Paths.get(
            modulePath.toString(),
            "src/main/java",
            toPath(projectDescription.getGroupId()),
            "config",
            "springdoc",
            "SpringDocConfiguration.java"));
  }

  private void exportJavaActuator(
      ProjectDescription projectDescription, Path modulePath, Map<String, Object> dataModel) {
    freemarkerService.exportIfNotExists(
        dataModel,
        "trinity-scaffolder-java/app/src/main/java/actuator/OpenApiAdminEndpoint.java.ftl",
        Paths.get(
            modulePath.toString(),
            "src/main/java",
            toPath(projectDescription.getGroupId()),
            "actuator",
            "OpenApiAdminEndpoint.java"));

    freemarkerService.exportIfNotExists(
        dataModel,
        "trinity-scaffolder-java/app/src/main/java/actuator/OpenApiSystemEndpoint.java.ftl",
        Paths.get(
            modulePath.toString(),
            "src/main/java",
            toPath(projectDescription.getGroupId()),
            "actuator",
            "OpenApiSystemEndpoint.java"));

    freemarkerService.exportIfNotExists(
        dataModel,
        "trinity-scaffolder-java/app/src/main/java/actuator/OpenApiUserEndpoint.java.ftl",
        Paths.get(
            modulePath.toString(),
            "src/main/java",
            toPath(projectDescription.getGroupId()),
            "actuator",
            "OpenApiUserEndpoint.java"));
  }

  private void exportTest(
      ProjectDescription projectDescription, Path modulePath, Map<String, Object> dataModel) {
    freemarkerService.exportIfNotExists(
        dataModel,
        "trinity-scaffolder-java/app/test/src/testcontainers/ActiveMqContainer.java.ftl.java",
        Paths.get(
            modulePath.toString(),
            "src/test/java",
            toPath(projectDescription.getGroupId()),
            "testcontainers",
            "ActiveMqContainer.java"));

    freemarkerService.exportIfNotExists(
        dataModel,
        "trinity-scaffolder-java/app/test/src/CucumberIntegrationTest.java.ftl.java",
        Paths.get(
            modulePath.toString(),
            "src/test/java",
            toPath(projectDescription.getGroupId()),
            "CucumberIntegrationTest.java"));

    try {
      Files.copy(
          getClass()
              .getResourceAsStream(
                  "/ftl/trinity-scaffolder-java/app/test/resources/cucumber.properties"),
          Paths.get(modulePath.toString(), "src/test/resources", "cucumber.properties"),
          StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }
  }

  private void exportApplicationYml(Path modulePath, Map<String, Object> dataModel) {
    freemarkerService.exportIfNotExists(
        dataModel,
        "trinity-scaffolder-java/app/resources/application.yml.ftl",
        Paths.get(modulePath.toString(), "src/main/resources", "application.yml"));
  }

  private void exportConfigApplicationDevYml(
      AppConfigLocationType appConfigLocationType, Path modulePath, Map<String, Object> dataModel) {
    if (appConfigLocationType.equals(AppConfigLocationType.INSIDE)) {
      freemarkerService.exportIfNotExists(
          dataModel,
          "trinity-scaffolder-java/app/resources/config/application-dev.yml.ftl",
          Paths.get(modulePath.toString(), "src/main/resources/config", "application-dev.yml"));
    } else if (appConfigLocationType.equals(AppConfigLocationType.OUTSIDE)) {
      freemarkerService.exportIfNotExists(
          dataModel,
          "trinity-scaffolder-java/app/resources/config/application-dev.yml.ftl",
          Paths.get(modulePath.toString(), "config", "application.yml"));
    }
  }

  private void exportConfigApplicationCiYml(
      AppConfigLocationType appConfigLocationType, Path modulePath, Map<String, Object> dataModel) {
    if (appConfigLocationType.equals(AppConfigLocationType.INSIDE)) {
      freemarkerService.exportIfNotExists(
          dataModel,
          "trinity-scaffolder-java/app/resources/config/application-ci.yml.ftl",
          Paths.get(modulePath.toString(), "src/main/resources/config", "application-ci.yml"));
    } else if (appConfigLocationType.equals(AppConfigLocationType.OUTSIDE)) {
      freemarkerService.exportIfNotExists(
          dataModel,
          "trinity-scaffolder-java/app/resources/config/application-ci.yml.ftl",
          Paths.get(modulePath.toString(), "config", "application-ci.yml"));
    }
  }
}
