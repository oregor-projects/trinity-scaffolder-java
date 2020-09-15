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

  private final ApiClientDomainMessageScaffolder apiClientDomainMessageScaffolder;
  private final ApiClientDomainMessageActiveMqScaffolder apiClientDomainMessageActiveMqScaffolder;

  private final ApiClientBatchProcessScaffolder apiClientBatchProcessScaffolder;
  private final ApiClientBatchProcessActiveMqScaffolder apiClientBatchProcessActiveMqScaffolder;

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
   * @param apiClientDomainMessageScaffolder the api client domain message scaffolder
   * @param apiClientDomainMessageActiveMqScaffolder the api client domain message active mq
   *     scaffolder
   * @param apiClientBatchProcessScaffolder the api client batch process scaffolder
   * @param apiClientBatchProcessActiveMqScaffolder the api client batch process active mq
   *     scaffolder
   */
  public ApiFamilyScaffolder(
      FreemarkerService freemarkerService,
      ApiScaffolder apiScaffolder,
      ApiDetailScaffolder apiDetailScaffolder,
      ApiClientsScaffolder apiClientsScaffolder,
      ApiClientRestScaffolder apiClientRestScaffolder,
      ApiClientDomainMessageScaffolder apiClientDomainMessageScaffolder,
      ApiClientDomainMessageActiveMqScaffolder apiClientDomainMessageActiveMqScaffolder,
      ApiClientBatchProcessScaffolder apiClientBatchProcessScaffolder,
      ApiClientBatchProcessActiveMqScaffolder apiClientBatchProcessActiveMqScaffolder) {
    super(freemarkerService);
    this.apiScaffolder = apiScaffolder;
    this.apiDetailScaffolder = apiDetailScaffolder;
    this.apiClientsScaffolder = apiClientsScaffolder;
    this.apiClientRestScaffolder = apiClientRestScaffolder;
    this.apiClientDomainMessageScaffolder = apiClientDomainMessageScaffolder;
    this.apiClientDomainMessageActiveMqScaffolder = apiClientDomainMessageActiveMqScaffolder;
    this.apiClientBatchProcessScaffolder = apiClientBatchProcessScaffolder;
    this.apiClientBatchProcessActiveMqScaffolder = apiClientBatchProcessActiveMqScaffolder;
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

              // Domain Message
              apiClientDomainMessageScaffolder.scaffold(
                  generationPathWithContext, contextDescription, dataModel);
              apiClientDomainMessageActiveMqScaffolder.scaffold(
                  generationPathWithContext, contextDescription, dataModel);

              // Batch Process
              if (projectDescription.getEnablement().isApiClientBatchProcessScaffolder()) {
                apiClientBatchProcessScaffolder.scaffold(
                    generationPathWithContext, contextDescription, dataModel);
              }

              if (projectDescription.getEnablement().isApiClientBatchProcessActiveMqScaffolder()) {
                apiClientBatchProcessActiveMqScaffolder.scaffold(
                    generationPathWithContext, contextDescription, dataModel);
              }
            });
  }
}
