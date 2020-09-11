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

import com.oregor.trinity.scaffolder.java.core.AbstractContextScaffolder;
import com.oregor.trinity.scaffolder.java.core.ContextDescription;
import com.oregor.trinity.scaffolder.java.freemarker.FreemarkerService;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * The type Domain details scaffolder.
 *
 * @author Christos Tsakostas
 */
public class DomainDetailsScaffolder extends AbstractContextScaffolder {

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Domain details scaffolder.
   *
   * @param freemarkerService the freemarker service
   */
  public DomainDetailsScaffolder(FreemarkerService freemarkerService) {
    super(freemarkerService);
  }

  // ===============================================================================================
  // BEHAVIOUR
  // ===============================================================================================

  @Override
  public void scaffold(
      Path generationPath, ContextDescription contextDescription, Map<String, Object> dataModel) {

    Path modulePath =
        Paths.get(
            generationPath.toString(), contextDescription.getModulePrefix() + "domain-details");

    exportDomainDetailsMavenPomXml(modulePath, dataModel);
  }

  private void exportDomainDetailsMavenPomXml(Path modulePath, Map<String, Object> dataModel) {

    freemarkerService.exportIfNotExists(
        dataModel,
        "trinity-scaffolder-java/domain-details/pom.xml.ftl",
        Paths.get(modulePath.toString(), "pom.xml"));
  }
}
