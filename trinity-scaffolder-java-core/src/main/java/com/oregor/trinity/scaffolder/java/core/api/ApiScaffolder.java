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

package com.oregor.trinity.scaffolder.java.core.api;

import com.oregor.trinity.scaffolder.java.core.AbstractScaffolder;
import com.oregor.trinity.scaffolder.java.core.ProjectDescription;
import com.oregor.trinity.scaffolder.java.freemarker.FreemarkerService;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * The type Api scaffolder.
 *
 * @author Christos Tsakostas
 */
public class ApiScaffolder extends AbstractScaffolder {

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Api scaffolder.
   *
   * @param freemarkerService the freemarker service
   */
  public ApiScaffolder(FreemarkerService freemarkerService) {
    super(freemarkerService);
  }

  // ===============================================================================================
  // BEHAVIOUR
  // ===============================================================================================

  @Override
  public void scaffold(
      Path generationPath, ProjectDescription projectDescription, Map<String, Object> dataModel) {

    Path modulePath =
        Paths.get(
            generationPath.toString(),
            String.format("%s-api", projectDescription.getModulePrefix()));

    ensureSources(modulePath, projectDescription);

    freemarkerService.export(
        dataModel,
        "trinity-scaffolder-java/api/pom.xml.ftl",
        Paths.get(modulePath.toString(), "pom.xml"));
  }
}
