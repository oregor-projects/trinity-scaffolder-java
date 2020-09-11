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

package com.oregor.trinity.scaffolder.java;

import com.oregor.trinity.scaffolder.java.core.ProjectDescription;
import com.oregor.trinity.scaffolder.java.core.ProjectDescriptionBuilder;
import com.oregor.trinity.scaffolder.java.core.TrinityScaffolderJava;
import com.oregor.trinity.scaffolder.java.core.TrinityScaffolderJavaFactory;
import java.nio.file.Path;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type TrinityScaffolderJavaLauncher.
 *
 * @author Christos Tsakostas
 */
public class TrinityScaffolderJavaLauncher {

  private static final Logger LOG = LoggerFactory.getLogger(TrinityScaffolderJavaLauncher.class);

  // ===============================================================================================
  // STATE
  // ===============================================================================================

  private Scanner scanner;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new TrinityScaffolderJavaLauncher.
   *
   * @param scanner the scanner
   */
  public TrinityScaffolderJavaLauncher(Scanner scanner) {
    this.scanner = scanner;
  }

  // ===============================================================================================
  // FUNCTIONALITY
  // ===============================================================================================

  /**
   * Launch.
   *
   * @param scaffoldingPath the scaffolding path
   */
  public void run(Path scaffoldingPath) {
    LOG.info("*************************************************");
    LOG.info("Trinity Scaffolder for Java CLI");
    LOG.info("*************************************************");

    ProjectDescriptionBuilder projectDescriptionBuilder = new ProjectDescriptionBuilder();

    groupId(projectDescriptionBuilder);
    artifactId(projectDescriptionBuilder);

    TrinityScaffolderJava trinityScaffolderJava = TrinityScaffolderJavaFactory.newInstance();

    trinityScaffolderJava.scaffold(scaffoldingPath, projectDescription(projectDescriptionBuilder));

    LOG.info("Done!");
  }

  // ===============================================================================================
  // PRIVATE
  // ===============================================================================================

  private void groupId(ProjectDescriptionBuilder projectDescriptionBuilder) {
    LOG.info("Enter GroupId (i.e. com.company.project): ");

    String providedGroupId = scanner.nextLine();
    if (!providedGroupId.equals("")) {
      projectDescriptionBuilder.setGroupId(providedGroupId);
    }
  }

  private void artifactId(ProjectDescriptionBuilder projectDescriptionBuilder) {
    LOG.info("Enter ArtifactId (i.e. project): ");

    String providedArtifactId = scanner.nextLine();
    if (!providedArtifactId.equals("")) {
      projectDescriptionBuilder.setArtifactId(providedArtifactId);
      projectDescriptionBuilder.setModulePrefix(providedArtifactId);
    }
  }

  private ProjectDescription projectDescription(
      ProjectDescriptionBuilder projectDescriptionBuilder) {
    ProjectDescription projectDescription = projectDescriptionBuilder.createProjectDescription();

    LOG.info("Creating Project...");
    LOG.info("GroupId is: {}", projectDescription.getGroupId());
    LOG.info("ArtifactId is: {}", projectDescription.getArtifactId());

    return projectDescription;
  }
}
