/*-
 * ==========================LICENSE_START=================================
 * Trinity Scaffolder for Java Applications
 * ========================================================================
 * Copyright (C) 2017 - 2019 OREGOR LTD
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

import static org.mockito.Mockito.mock;

import com.oregor.trinity.scaffolder.java.freemarker.FreemarkerService;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Abstract trinity scaffolder java test.
 *
 * @author Christos Tsakostas
 */
public abstract class AbstractTrinityScaffolderJavaTest {

  /** The Freemarker service. */
  protected FreemarkerService freemarkerService;

  /** Instantiates a new Abstract trinity scaffolder java test. */
  public AbstractTrinityScaffolderJavaTest() {
    freemarkerService = mock(FreemarkerService.class);
  }

  /**
   * Generation path path.
   *
   * @return the path
   */
  protected Path generationPath() {
    return Paths.get("tmp");
  }

  /**
   * Project description project description.
   *
   * @return the project description
   */
  protected ProjectDescription projectDescription() {
    return new ProjectDescriptionBuilder()
        .setContext("context")
        .setGroupId("com.oregor")
        .setArtifactId("test-project")
        .setVersion("0.0.1")
        .setModulePrefix("prefix")
        .setName("sample-name")
        .setDescription("Sample Description")
        .setUrl("https://www.oregor.com")
        .setInceptionYear("2019")
        .setOrganizationName("OREGOR LTD")
        .setOrganizationUrl("https://www.oregor.com")
        .setLicenseName("APACHE")
        .setScmConnection("")
        .setScmDeveloperConnection("")
        .setScmUrl("")
        .setDistributionProfile("oss")
        .createProjectDescription();
  }

  /**
   * Data model map.
   *
   * @return the map
   */
  protected Map<String, Object> dataModel() {
    Map<String, Object> map = new HashMap<>();
    return map;
  }
}
