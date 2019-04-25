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

package com.oregor.trinity.scaffolder.java.core.extra;

import com.oregor.trinity.scaffolder.java.core.AbstractScaffolder;
import com.oregor.trinity.scaffolder.java.core.ProjectDescription;
import com.oregor.trinity.scaffolder.java.freemarker.FreemarkerService;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class ExtraModuleScaffolder extends AbstractScaffolder {

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Extra module scaffolder.
   *
   * @param freemarkerService the freemarker service
   */
  public ExtraModuleScaffolder(FreemarkerService freemarkerService) {
    super(freemarkerService);
  }

  // ===============================================================================================
  // BEHAVIOUR
  // ===============================================================================================

  @Override
  public void scaffold(
      Path generationPath, ProjectDescription projectDescription, Map<String, Object> dataModel) {

    projectDescription
        .getExtraModules()
        .forEach(module -> scaffoldModule(generationPath, projectDescription, dataModel, module));
  }

  // ===============================================================================================
  // PRIVATE
  // ===============================================================================================

  private void scaffoldModule(
      Path generationPath,
      ProjectDescription projectDescription,
      Map<String, Object> dataModel,
      String module) {
    Path modulePath =
        Paths.get(generationPath.toString(), projectDescription.getModulePrefix() + "" + module);

    ensureSources(modulePath, projectDescription);

    dataModel.put("module", module);

    freemarkerService.export(
        dataModel,
        "trinity-scaffolder-java/extra-module/pom.xml.ftl",
        Paths.get(modulePath.toString(), "pom.xml"));
  }
}
