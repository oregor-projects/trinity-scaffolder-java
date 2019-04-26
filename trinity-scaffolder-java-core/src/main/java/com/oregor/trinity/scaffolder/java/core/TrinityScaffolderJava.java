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

import com.oregor.trinity.scaffolder.java.core.api.ApiFamilyScaffolder;
import com.oregor.trinity.scaffolder.java.core.app.AppScaffolder;
import com.oregor.trinity.scaffolder.java.core.aux.AuxFamilyScaffolder;
import com.oregor.trinity.scaffolder.java.core.domain.DomainFamilyScaffolder;
import com.oregor.trinity.scaffolder.java.core.extra.ExtraModuleScaffolder;
import com.oregor.trinity.scaffolder.java.core.project.ProjectFamilyScaffolder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Trinity scaffolder java.
 *
 * @author Christos Tsakostas
 */
public class TrinityScaffolderJava {

  // ===============================================================================================
  // DEPENDENCIES
  // ===============================================================================================
  private final ProjectFamilyScaffolder projectFamilyScaffolder;
  private final AppScaffolder appScaffolder;
  private final ApiFamilyScaffolder apiFamilyScaffolder;
  private final AuxFamilyScaffolder auxFamilyScaffolder;
  private final DomainFamilyScaffolder domainFamilyScaffolder;
  private final ExtraModuleScaffolder extraModuleScaffolder;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Trinity scaffolder java.
   *
   * @param projectFamilyScaffolder the project family scaffolder
   * @param appScaffolder the app scaffolder
   * @param apiFamilyScaffolder the api family scaffolder
   * @param auxFamilyScaffolder the aux family scaffolder
   * @param domainFamilyScaffolder the domain family scaffolder
   * @param extraModuleScaffolder the extra module scaffolder
   */
  public TrinityScaffolderJava(
      ProjectFamilyScaffolder projectFamilyScaffolder,
      AppScaffolder appScaffolder,
      ApiFamilyScaffolder apiFamilyScaffolder,
      AuxFamilyScaffolder auxFamilyScaffolder,
      DomainFamilyScaffolder domainFamilyScaffolder,
      ExtraModuleScaffolder extraModuleScaffolder) {
    this.projectFamilyScaffolder = projectFamilyScaffolder;
    this.appScaffolder = appScaffolder;
    this.apiFamilyScaffolder = apiFamilyScaffolder;
    this.auxFamilyScaffolder = auxFamilyScaffolder;
    this.domainFamilyScaffolder = domainFamilyScaffolder;
    this.extraModuleScaffolder = extraModuleScaffolder;
  }

  // ===============================================================================================
  // FUNCTIONALITY
  // ===============================================================================================

  /**
   * Scaffold.
   *
   * @param generationPath the generation path
   * @param projectDescription the project description
   */
  public void scaffold(Path generationPath, ProjectDescription projectDescription) {
    Map<String, Object> dataModel = new HashMap<>();
    dataModel.put("projectDescription", projectDescription);

    Path generationPathProject =
        Paths.get(generationPath.toString(), projectDescription.getArtifactId());

    projectFamilyScaffolder.scaffold(generationPathProject, projectDescription, dataModel);
    appScaffolder.scaffold(generationPathProject, projectDescription, dataModel);
    apiFamilyScaffolder.scaffold(generationPathProject, projectDescription, dataModel);
    auxFamilyScaffolder.scaffold(generationPathProject, projectDescription, dataModel);
    domainFamilyScaffolder.scaffold(generationPathProject, projectDescription, dataModel);
    extraModuleScaffolder.scaffold(generationPathProject, projectDescription, dataModel);
  }
}
