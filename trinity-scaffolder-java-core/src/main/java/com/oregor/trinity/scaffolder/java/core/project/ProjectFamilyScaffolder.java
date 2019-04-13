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

package com.oregor.trinity.scaffolder.java.core.project;

import com.oregor.trinity.scaffolder.java.core.AbstractScaffolder;
import com.oregor.trinity.scaffolder.java.core.ProjectDescription;
import com.oregor.trinity.scaffolder.java.freemarker.FreemarkerService;
import java.nio.file.Path;
import java.util.Map;

/**
 * The type Project family scaffolder.
 *
 * @author Christos Tsakostas
 */
public class ProjectFamilyScaffolder extends AbstractScaffolder {

  // ===============================================================================================
  // DEPENDENCIES
  // ===============================================================================================
  private GitIgnoreScaffolder gitIgnoreScaffolder;
  private MavenParentPomScaffolder mavenParentPomScaffolder;
  private MavenSettingsScaffolder mavenSettingsScaffolder;
  private RootScaffolder rootScaffolder;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Project family scaffolder.
   *
   * @param freemarkerService the freemarker service
   * @param gitIgnoreScaffolder the git ignore scaffolder
   * @param mavenParentPomScaffolder the maven parent pom scaffolder
   * @param mavenSettingsScaffolder the maven settings scaffolder
   * @param rootScaffolder the root scaffolder
   */
  public ProjectFamilyScaffolder(
      FreemarkerService freemarkerService,
      GitIgnoreScaffolder gitIgnoreScaffolder,
      MavenParentPomScaffolder mavenParentPomScaffolder,
      MavenSettingsScaffolder mavenSettingsScaffolder,
      RootScaffolder rootScaffolder) {
    super(freemarkerService);
    this.gitIgnoreScaffolder = gitIgnoreScaffolder;
    this.mavenParentPomScaffolder = mavenParentPomScaffolder;
    this.mavenSettingsScaffolder = mavenSettingsScaffolder;
    this.rootScaffolder = rootScaffolder;
  }

  // ===============================================================================================
  // BEHAVIOUR
  // ===============================================================================================

  @Override
  public void scaffold(
      Path generationPath, ProjectDescription projectDescription, Map<String, Object> dataModel) {

    gitIgnoreScaffolder.scaffold(generationPath, projectDescription, dataModel);
    mavenParentPomScaffolder.scaffold(generationPath, projectDescription, dataModel);
    mavenSettingsScaffolder.scaffold(generationPath, projectDescription, dataModel);
    rootScaffolder.scaffold(generationPath, projectDescription, dataModel);
  }
}
