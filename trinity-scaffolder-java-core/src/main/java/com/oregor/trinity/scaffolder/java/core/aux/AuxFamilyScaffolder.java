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

package com.oregor.trinity.scaffolder.java.core.aux;

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
public class AuxFamilyScaffolder extends AbstractProjectScaffolder {

  // ===============================================================================================
  // DEPENDENCIES
  // ===============================================================================================

  private final AuxScaffolder auxScaffolder;
  private final AuxDetailsScaffolder auxDetailsScaffolder;

  private final AuxDetailPropertyFileScaffolder auxDetailPropertyFileScaffolder;
  private final AuxDetailAlertSlackScaffolder auxDetailAlertSlackScaffolder;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Aux family scaffolder.
   *
   * @param freemarkerService the freemarker service
   * @param auxScaffolder the aux scaffolder
   * @param auxDetailsScaffolder the aux details scaffolder
   * @param auxDetailPropertyFileScaffolder the aux detail property file scaffolder
   * @param auxDetailAlertSlackScaffolder the aux detail alert slack scaffolder
   */
  public AuxFamilyScaffolder(
      FreemarkerService freemarkerService,
      AuxScaffolder auxScaffolder,
      AuxDetailsScaffolder auxDetailsScaffolder,
      AuxDetailPropertyFileScaffolder auxDetailPropertyFileScaffolder,
      AuxDetailAlertSlackScaffolder auxDetailAlertSlackScaffolder) {
    super(freemarkerService);
    this.auxScaffolder = auxScaffolder;
    this.auxDetailsScaffolder = auxDetailsScaffolder;
    this.auxDetailPropertyFileScaffolder = auxDetailPropertyFileScaffolder;
    this.auxDetailAlertSlackScaffolder = auxDetailAlertSlackScaffolder;
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

              auxScaffolder.scaffold(generationPathWithContext, contextDescription, dataModel);

              auxDetailsScaffolder.scaffold(
                  generationPathWithContext, contextDescription, dataModel);

              auxDetailPropertyFileScaffolder.scaffold(
                  generationPathWithContext, contextDescription, dataModel);

              auxDetailAlertSlackScaffolder.scaffold(
                  generationPathWithContext, contextDescription, dataModel);
            });
  }
}
