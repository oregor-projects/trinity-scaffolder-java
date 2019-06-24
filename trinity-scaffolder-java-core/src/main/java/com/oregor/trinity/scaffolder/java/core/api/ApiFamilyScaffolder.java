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

import com.oregor.trinity.scaffolder.java.core.AbstractProjectScaffolder;
import com.oregor.trinity.scaffolder.java.core.ProjectDescription;
import com.oregor.trinity.scaffolder.java.freemarker.FreemarkerService;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * The type Api family scaffolder.
 *
 * @author Christos Tsakostas
 */
public class ApiFamilyScaffolder extends AbstractProjectScaffolder {

  // ===============================================================================================
  // DEPENDENCIES
  // ===============================================================================================

  private final ApiScaffolder apiScaffolder;
  private final ApiDetailScaffolder apiDetailScaffolder;
  private final ApiClientsScaffolder apiClientsScaffolder;
  private final ApiClientRestScaffolder apiClientRestScaffolder;
  private final ApiClientSchedulerScaffolder apiClientSchedulerScaffolder;
  private final ApiClientSubscriberScaffolder apiClientSubscriberScaffolder;
  private final ApiClientSubscriberActiveMqScaffolder apiClientSubscriberActiveMqScaffolder;
  private final ApiClientPeriodicProcessScaffolder apiClientPeriodicProcessScaffolder;
  private final ApiClientPeriodicProcessTriggerActiveMqScaffolder
      apiClientPeriodicProcessTriggerActiveMqScaffolder;

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
   * @param apiClientSchedulerScaffolder the api client scheduler scaffolder
   * @param apiClientSubscriberScaffolder the api client subscriber scaffolder
   * @param apiClientSubscriberActiveMqScaffolder the api client subscriber active mq scaffolder
   * @param apiClientPeriodicProcessScaffolder the api client periodic process scaffolder
   * @param apiClientPeriodicProcessTriggerActiveMqScaffolder the api client periodic process
   *     trigger active mq scaffolder
   */
  public ApiFamilyScaffolder(
      FreemarkerService freemarkerService,
      ApiScaffolder apiScaffolder,
      ApiDetailScaffolder apiDetailScaffolder,
      ApiClientsScaffolder apiClientsScaffolder,
      ApiClientRestScaffolder apiClientRestScaffolder,
      ApiClientSchedulerScaffolder apiClientSchedulerScaffolder,
      ApiClientSubscriberScaffolder apiClientSubscriberScaffolder,
      ApiClientSubscriberActiveMqScaffolder apiClientSubscriberActiveMqScaffolder,
      ApiClientPeriodicProcessScaffolder apiClientPeriodicProcessScaffolder,
      ApiClientPeriodicProcessTriggerActiveMqScaffolder
          apiClientPeriodicProcessTriggerActiveMqScaffolder) {
    super(freemarkerService);
    this.apiScaffolder = apiScaffolder;
    this.apiDetailScaffolder = apiDetailScaffolder;
    this.apiClientsScaffolder = apiClientsScaffolder;
    this.apiClientRestScaffolder = apiClientRestScaffolder;
    this.apiClientSchedulerScaffolder = apiClientSchedulerScaffolder;
    this.apiClientSubscriberScaffolder = apiClientSubscriberScaffolder;
    this.apiClientSubscriberActiveMqScaffolder = apiClientSubscriberActiveMqScaffolder;
    this.apiClientPeriodicProcessScaffolder = apiClientPeriodicProcessScaffolder;
    this.apiClientPeriodicProcessTriggerActiveMqScaffolder =
        apiClientPeriodicProcessTriggerActiveMqScaffolder;
  }

  // ===============================================================================================
  // BEHAVIOUR
  // ===============================================================================================

  @Override
  public void scaffold(
      Path generationPath, ProjectDescription projectDescription, Map<String, Object> dataModel) {

    projectDescription
        .getContextDescriptions()
        .forEach(
            contextDescription -> {
              Path generationPathWithContext =
                  Paths.get(generationPath.toString(), contextDescription.getContextFolder());

              dataModel.put("contextDescription", contextDescription);

              apiScaffolder.scaffold(generationPathWithContext, contextDescription, dataModel);
              apiDetailScaffolder.scaffold(
                  generationPathWithContext, contextDescription, dataModel);
              apiClientsScaffolder.scaffold(
                  generationPathWithContext, contextDescription, dataModel);
              apiClientRestScaffolder.scaffold(
                  generationPathWithContext, contextDescription, dataModel);
              apiClientSchedulerScaffolder.scaffold(
                  generationPathWithContext, contextDescription, dataModel);
              apiClientSubscriberScaffolder.scaffold(
                  generationPathWithContext, contextDescription, dataModel);
              apiClientSubscriberActiveMqScaffolder.scaffold(
                  generationPathWithContext, contextDescription, dataModel);
              apiClientPeriodicProcessScaffolder.scaffold(
                  generationPathWithContext, contextDescription, dataModel);
              apiClientPeriodicProcessTriggerActiveMqScaffolder.scaffold(
                  generationPathWithContext, contextDescription, dataModel);
            });
  }
}
