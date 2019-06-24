/*-
 * ==========================LICENSE_START=================================
 * Trinity Scaffolder for Java Applications
 * ========================================================================
 * Copyright (C) 2019 Christos Tsakostas, OREGOR LTD
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

package com.oregor.trinity.scaffolder.java.core;

import static org.assertj.core.api.Assertions.assertThat;

import com.oregor.trinity.scaffolder.java.AbstractEqualityTest;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import org.junit.Test;

/** @author Christos Tsakostas */
public class ProjectDescriptionTest extends AbstractEqualityTest<ProjectDescription> {

  @Test
  public void shouldInstantiate() {
    ProjectDescription projectDescription = createObject1();

    assertThat(projectDescription.getContext()).isEqualTo("context");
    assertThat(projectDescription.getGroupId()).isEqualTo("com.company.project");
    assertThat(projectDescription.getArtifactId()).isEqualTo("artifactId");
    assertThat(projectDescription.getModulePrefix()).isEqualTo("prefix-");
    assertThat(projectDescription.getVersion()).isEqualTo("0.0.1-SNAPSHOT");
    assertThat(projectDescription.getName()).isEqualTo("Project Name");
    assertThat(projectDescription.getDescription()).isEqualTo("Project Description");
    assertThat(projectDescription.getUrl()).isEqualTo("https://www.company-project.com");
    assertThat(projectDescription.getInceptionYear())
        .isEqualTo(String.valueOf(LocalDateTime.now().getYear()));
    assertThat(projectDescription.getOrganizationName()).isEqualTo("Your Company Name");
    assertThat(projectDescription.getOrganizationUrl()).isEqualTo("https://www.company.com");
    assertThat(projectDescription.getLicenseName()).isEqualTo("apache_v2");
    assertThat(projectDescription.getLicenseUrl()).isEqualTo("https://www.license-url.com");
    assertThat(projectDescription.getScmConnection()).isEqualTo("");
    assertThat(projectDescription.getScmDeveloperConnection()).isEqualTo("");
    assertThat(projectDescription.getScmUrl()).isEqualTo("");
    assertThat(projectDescription.getDistributionProfile()).isEqualTo("");
    assertThat(projectDescription.getExtraModules().size()).isEqualTo(0);
  }

  @Override
  public ProjectDescription createObject1() {
    return new ProjectDescription(
        "project",
        "context",
        "com.company.project",
        "artifactId",
        "prefix",
        "0.0.1-SNAPSHOT",
        "Project Name",
        "Project Description",
        "https://www.company-project.com",
        String.valueOf(LocalDateTime.now().getYear()),
        "Your Company Name",
        "https://www.company.com",
        "apache_v2",
        "https://www.license-url.com",
        "",
        "",
        "",
        "",
        new LinkedHashSet<>(),
        new LinkedHashSet<>());
  }

  @Override
  public ProjectDescription createObject2() {
    return new ProjectDescription(
        "someOtherProject",
        "someOtherContext",
        "com.company.project",
        "artifactId",
        "prefix",
        "0.0.1-SNAPSHOT",
        "Project Name",
        "Project Description",
        "https://www.company-project.com",
        String.valueOf(LocalDateTime.now().getYear()),
        "Your Company Name",
        "https://www.company.com",
        "apache_v2",
        "https://www.license-url.com",
        "",
        "",
        "",
        "",
        new LinkedHashSet<>(),
        new LinkedHashSet<>());
  }
}
