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

package com.oregor.trinity.scaffolder.java.core.domain;

import com.oregor.trinity.scaffolder.java.core.AbstractScaffolder;
import com.oregor.trinity.scaffolder.java.core.ProjectDescription;
import com.oregor.trinity.scaffolder.java.freemarker.FreemarkerService;
import java.nio.file.Path;
import java.util.Map;

/**
 * The type Domain family scaffolder.
 *
 * @author Christos Tsakostas
 */
public class DomainFamilyScaffolder extends AbstractScaffolder {

  // ===============================================================================================
  // DEPENDENCIES
  // ===============================================================================================

  private final DomainModelScaffolder domainModelScaffolder;
  private final DomainDetailsScaffolder domainDetailsScaffolder;
  private final DomainServicesScaffolder domainServicesScaffolder;
  private final DomainDetailsRepositorySpringDataJpaScaffolder
      domainDetailsRepositorySpringDataJpaScaffolder;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Domain family scaffolder.
   *
   * @param freemarkerService the freemarker service
   * @param domainModelScaffolder the domain model scaffolder
   * @param domainDetailsScaffolder the domain details scaffolder
   * @param domainServicesScaffolder the domain services scaffolder
   * @param domainDetailsRepositorySpringDataJpaScaffolder the domain details persistence rdbms
   *     scaffolder
   */
  public DomainFamilyScaffolder(
      FreemarkerService freemarkerService,
      DomainModelScaffolder domainModelScaffolder,
      DomainDetailsScaffolder domainDetailsScaffolder,
      DomainServicesScaffolder domainServicesScaffolder,
      DomainDetailsRepositorySpringDataJpaScaffolder
          domainDetailsRepositorySpringDataJpaScaffolder) {
    super(freemarkerService);
    this.domainModelScaffolder = domainModelScaffolder;
    this.domainDetailsScaffolder = domainDetailsScaffolder;
    this.domainServicesScaffolder = domainServicesScaffolder;
    this.domainDetailsRepositorySpringDataJpaScaffolder =
        domainDetailsRepositorySpringDataJpaScaffolder;
  }

  // ===============================================================================================
  // BEHAVIOUR
  // ===============================================================================================

  @Override
  public void scaffold(
      Path generationPath, ProjectDescription projectDescription, Map<String, Object> dataModel) {

    domainModelScaffolder.scaffold(generationPath, projectDescription, dataModel);
    domainDetailsScaffolder.scaffold(generationPath, projectDescription, dataModel);
    domainServicesScaffolder.scaffold(generationPath, projectDescription, dataModel);
    domainDetailsRepositorySpringDataJpaScaffolder.scaffold(
        generationPath, projectDescription, dataModel);
  }
}
