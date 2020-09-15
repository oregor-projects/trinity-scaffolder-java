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

package com.oregor.trinity.scaffolder.java.core.domain;

import com.oregor.trinity.scaffolder.java.core.AbstractProjectScaffolder;
import com.oregor.trinity.scaffolder.java.core.ProjectDescription;
import com.oregor.trinity.scaffolder.java.freemarker.FreemarkerService;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * The type Domain family scaffolder.
 *
 * @author Christos Tsakostas
 */
public class DomainFamilyScaffolder extends AbstractProjectScaffolder {

  // ===============================================================================================
  // DEPENDENCIES
  // ===============================================================================================

  private final DomainModelScaffolder domainModelScaffolder;
  private final DomainDetailsScaffolder domainDetailsScaffolder;
  private final DomainDetailServicesScaffolder domainDetailServicesScaffolder;
  private final DomainDetailRepositoryInMemoryScaffolder domainDetailRepositoryInMemoryScaffolder;
  private final DomainDetailRepositorySpringDataJpaScaffolder
      domainDetailRepositorySpringDataJpaScaffolder;
  private final DomainDetailScheduledPublisherScaffolder domainDetailScheduledPublisherScaffolder;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Domain family scaffolder.
   *
   * @param freemarkerService the freemarker service
   * @param domainModelScaffolder the domain model scaffolder
   * @param domainDetailsScaffolder the domain details scaffolder
   * @param domainDetailServicesScaffolder the domain detail services scaffolder
   * @param domainDetailRepositoryInMemoryScaffolder the domain detail repository in memory
   *     scaffolder
   * @param domainDetailRepositorySpringDataJpaScaffolder the domain detail repository spring data
   *     jpa scaffolder
   * @param domainDetailScheduledPublisherScaffolder the domain detail scheduled publisher
   *     scaffolder
   */
  public DomainFamilyScaffolder(
      FreemarkerService freemarkerService,
      DomainModelScaffolder domainModelScaffolder,
      DomainDetailsScaffolder domainDetailsScaffolder,
      DomainDetailServicesScaffolder domainDetailServicesScaffolder,
      DomainDetailRepositoryInMemoryScaffolder domainDetailRepositoryInMemoryScaffolder,
      DomainDetailRepositorySpringDataJpaScaffolder domainDetailRepositorySpringDataJpaScaffolder,
      DomainDetailScheduledPublisherScaffolder domainDetailScheduledPublisherScaffolder) {
    super(freemarkerService);
    this.domainModelScaffolder = domainModelScaffolder;
    this.domainDetailsScaffolder = domainDetailsScaffolder;
    this.domainDetailServicesScaffolder = domainDetailServicesScaffolder;
    this.domainDetailRepositoryInMemoryScaffolder = domainDetailRepositoryInMemoryScaffolder;
    this.domainDetailRepositorySpringDataJpaScaffolder =
        domainDetailRepositorySpringDataJpaScaffolder;
    this.domainDetailScheduledPublisherScaffolder = domainDetailScheduledPublisherScaffolder;
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

              domainModelScaffolder.scaffold(
                  generationPathWithContext, contextDescription, dataModel);
              domainDetailsScaffolder.scaffold(
                  generationPathWithContext, contextDescription, dataModel);
              domainDetailServicesScaffolder.scaffold(
                  generationPathWithContext, contextDescription, dataModel);

              if (contextDescription.getEnablement().isDomainDetailRepositoryInMemoryScaffolder()) {
                domainDetailRepositoryInMemoryScaffolder.scaffold(
                    generationPathWithContext, contextDescription, dataModel);
              }

              domainDetailRepositorySpringDataJpaScaffolder.scaffold(
                  generationPathWithContext, contextDescription, dataModel);
              domainDetailScheduledPublisherScaffolder.scaffold(
                  generationPathWithContext, contextDescription, dataModel);
            });
  }
}
