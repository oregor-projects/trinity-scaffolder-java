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

package com.oregor.trinity.scaffolder.java.core.aux;

import com.oregor.trinity.scaffolder.java.core.AbstractScaffolder;
import com.oregor.trinity.scaffolder.java.core.ProjectDescription;
import com.oregor.trinity.scaffolder.java.freemarker.FreemarkerService;
import java.nio.file.Path;
import java.util.Map;

/**
 * The type Api family scaffolder.
 *
 * @author Christos Tsakostas
 */
public class AuxFamilyScaffolder extends AbstractScaffolder {

  // ===============================================================================================
  // DEPENDENCIES
  // ===============================================================================================

  private final AuxScaffolder auxScaffolder;
  private final AuxDetailsScaffolder auxDetailsScaffolder;
  private final AuxDetailPublisherScaffolder auxDetailPublisherScaffolder;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Aux family scaffolder.
   *
   * @param freemarkerService the freemarker service
   * @param auxScaffolder the aux scaffolder
   * @param auxDetailsScaffolder the aux details scaffolder
   * @param auxDetailPublisherScaffolder the aux detail publisher scaffolder
   */
  public AuxFamilyScaffolder(
      FreemarkerService freemarkerService,
      AuxScaffolder auxScaffolder,
      AuxDetailsScaffolder auxDetailsScaffolder,
      AuxDetailPublisherScaffolder auxDetailPublisherScaffolder) {
    super(freemarkerService);
    this.auxScaffolder = auxScaffolder;
    this.auxDetailsScaffolder = auxDetailsScaffolder;
    this.auxDetailPublisherScaffolder = auxDetailPublisherScaffolder;
  }

  // ===============================================================================================
  // BEHAVIOUR
  // ===============================================================================================

  @Override
  public void scaffold(
      Path generationPath, ProjectDescription projectDescription, Map<String, Object> dataModel) {

    auxScaffolder.scaffold(generationPath, projectDescription, dataModel);
    auxDetailsScaffolder.scaffold(generationPath, projectDescription, dataModel);
    auxDetailPublisherScaffolder.scaffold(generationPath, projectDescription, dataModel);
  }
}
