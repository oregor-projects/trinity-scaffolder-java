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

import com.oregor.trinity.scaffolder.java.freemarker.FreemarkerService;
import com.oregor.trinity.scaffolder.java.path.PathService;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The type Abstract scaffolder.
 *
 * @author Christos Tsakostas
 */
public abstract class AbstractScaffolder {

  /** The Freemarker service. */
  protected final FreemarkerService freemarkerService;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Abstract scaffolder.
   *
   * @param freemarkerService the freemarker service
   */
  public AbstractScaffolder(FreemarkerService freemarkerService) {
    this.freemarkerService = freemarkerService;
  }

  // ===============================================================================================
  // BEHAVIOUR
  // ===============================================================================================

  /**
   * Ensure sources.
   *
   * @param generationPath the generation path
   * @param projectDescription the project description
   */
  // ===============================================================================================
  // PROTECTED
  // ===============================================================================================
  protected void ensureSources(Path generationPath, ProjectDescription projectDescription) {
    PathService.ensurePath(generationPath);

    PathService.ensurePath(
        Paths.get(
            generationPath.toString(), "src/main/java", toPath(projectDescription.getGroupId())));

    PathService.ensurePath(Paths.get(generationPath.toString(), "src/main/resources"));

    PathService.ensurePath(
        Paths.get(
            generationPath.toString(), "src/test/java", toPath(projectDescription.getGroupId())));

    PathService.ensurePath(Paths.get(generationPath.toString(), "src/test/resources"));
  }

  /**
   * Ensure sources.
   *
   * @param generationPath the generation path
   * @param contextDescription the context description
   */
  protected void ensureSources(Path generationPath, ContextDescription contextDescription) {
    PathService.ensurePath(generationPath);

    PathService.ensurePath(
        Paths.get(
            generationPath.toString(), "src/main/java", toPath(contextDescription.getGroupId())));

    PathService.ensurePath(Paths.get(generationPath.toString(), "src/main/resources"));

    PathService.ensurePath(
        Paths.get(
            generationPath.toString(), "src/test/java", toPath(contextDescription.getGroupId())));

    PathService.ensurePath(Paths.get(generationPath.toString(), "src/test/resources"));
  }

  /**
   * To path string.
   *
   * @param groupId the group id
   * @return the string
   */
  protected String toPath(String groupId) {
    return Paths.get(groupId.replaceAll("\\.", "/")).toString();
  }
}
