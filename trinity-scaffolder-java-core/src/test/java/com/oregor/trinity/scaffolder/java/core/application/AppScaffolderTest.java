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

package com.oregor.trinity.scaffolder.java.core.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.oregor.trinity.scaffolder.java.core.AbstractTrinityScaffolderJavaTest;
import com.oregor.trinity.scaffolder.java.core.app.AppScaffolder;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

/**
 * The type App scaffolder test.
 *
 * @author Christos Tsakostas
 */
public class AppScaffolderTest extends AbstractTrinityScaffolderJavaTest {

  private AppScaffolder appScaffolder;

  /** Sets up. */
  @Before
  public void setUp() {
    appScaffolder = new AppScaffolder(freemarkerService);
  }

  /** Should scaffold successfully. */
  @Test
  public void shouldScaffoldSuccessfully() {
    appScaffolder.scaffold(generationPath(), projectDescription(), dataModel());

    ArgumentCaptor<String> argumentCaptorFtlTemplate = ArgumentCaptor.forClass(String.class);
    ArgumentCaptor<Path> argumentCaptorPath = ArgumentCaptor.forClass(Path.class);

    verify(freemarkerService, times(6))
        .exportIfNotExists(
            eq(dataModel()), argumentCaptorFtlTemplate.capture(), argumentCaptorPath.capture());

    assertThat(
            argumentCaptorFtlTemplate
                .getAllValues()
                .contains("trinity-scaffolder-java/app/resources/application.yml.ftl"))
        .isTrue();
    assertThat(
            argumentCaptorFtlTemplate
                .getAllValues()
                .contains("trinity-scaffolder-java/app/resources/config/application-dev.yml.ftl"))
        .isTrue();
    assertThat(
            argumentCaptorFtlTemplate
                .getAllValues()
                .contains("trinity-scaffolder-java/app/resources/config/application-ci.yml.ftl"))
        .isTrue();
    assertThat(
            argumentCaptorFtlTemplate
                .getAllValues()
                .contains("trinity-scaffolder-java/app/pom.xml.ftl"))
        .isTrue();
    assertThat(
            argumentCaptorFtlTemplate
                .getAllValues()
                .contains("trinity-scaffolder-java/app/Application.java.ftl"))
        .isTrue();
    assertThat(
            argumentCaptorFtlTemplate
                .getAllValues()
                .contains("trinity-scaffolder-java/app/ApplicationTest.java.ftl"))
        .isTrue();

    assertThat(
            argumentCaptorPath
                .getAllValues()
                .contains(Paths.get("tmp/prefix-app/src/main/resources/application.yml")))
        .isTrue();
    assertThat(
            argumentCaptorPath
                .getAllValues()
                .contains(
                    Paths.get("tmp/prefix-app/src/main/resources/config/application-dev.yml")))
        .isTrue();
    assertThat(
            argumentCaptorPath
                .getAllValues()
                .contains(Paths.get("tmp/prefix-app/src/main/resources/config/application-ci.yml")))
        .isTrue();
    assertThat(argumentCaptorPath.getAllValues().contains(Paths.get("tmp/prefix-app/pom.xml")))
        .isTrue();
    assertThat(
            argumentCaptorPath
                .getAllValues()
                .contains(Paths.get("tmp/prefix-app/src/main/java/com/oregor/Application.java")))
        .isTrue();
    assertThat(
            argumentCaptorPath
                .getAllValues()
                .contains(
                    Paths.get("tmp/prefix-app/src/test/java/com/oregor/ApplicationTest.java")))
        .isTrue();
  }
}
