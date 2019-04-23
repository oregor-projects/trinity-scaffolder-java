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

package com.oregor.trinity.scaffolder.java.core.api;

import com.oregor.trinity.scaffolder.java.core.AbstractScaffolder;
import com.oregor.trinity.scaffolder.java.core.ProjectDescription;
import com.oregor.trinity.scaffolder.java.freemarker.FreemarkerService;
import java.nio.file.Path;
import java.util.Map;

/**
 * The type Api family scaffolder.
 *
 * @author Christos Tsakostas
 */
public class ApiFamilyScaffolder extends AbstractScaffolder {

  // ===============================================================================================
  // DEPENDENCIES
  // ===============================================================================================

  private final ApiScaffolder apiScaffolder;
  private final ApiDetailScaffolder apiDetailScaffolder;
  private final ApiClientsScaffolder apiClientsScaffolder;
  private final ApiClientRestScaffolder apiClientRestScaffolder;
  private final ApiClientSubscriberScaffolder apiClientSubscriberScaffolder;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Api family scaffolder.
   *
   * @param freemarkerService the freemarker service
   * @param apiScaffolder the api scaffolder
   * @param apiDetailScaffolder the api detail scaffolder
   * @param apiClientsScaffolder the api clients scaffolder
   * @param apiClientRestScaffolder the api client rest scaffolder
   * @param apiClientSubscriberScaffolder the api client subscriber scaffolder
   */
  public ApiFamilyScaffolder(
      FreemarkerService freemarkerService,
      ApiScaffolder apiScaffolder,
      ApiDetailScaffolder apiDetailScaffolder,
      ApiClientsScaffolder apiClientsScaffolder,
      ApiClientRestScaffolder apiClientRestScaffolder,
      ApiClientSubscriberScaffolder apiClientSubscriberScaffolder) {
    super(freemarkerService);
    this.apiScaffolder = apiScaffolder;
    this.apiDetailScaffolder = apiDetailScaffolder;
    this.apiClientsScaffolder = apiClientsScaffolder;
    this.apiClientRestScaffolder = apiClientRestScaffolder;
    this.apiClientSubscriberScaffolder = apiClientSubscriberScaffolder;
  }

  // ===============================================================================================
  // BEHAVIOUR
  // ===============================================================================================

  @Override
  public void scaffold(
      Path generationPath, ProjectDescription projectDescription, Map<String, Object> dataModel) {

    apiScaffolder.scaffold(generationPath, projectDescription, dataModel);
    apiDetailScaffolder.scaffold(generationPath, projectDescription, dataModel);
    apiClientsScaffolder.scaffold(generationPath, projectDescription, dataModel);
    apiClientRestScaffolder.scaffold(generationPath, projectDescription, dataModel);
    apiClientSubscriberScaffolder.scaffold(generationPath, projectDescription, dataModel);
  }
}
