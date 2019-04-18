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

package com.oregor.trinity.scaffolder.java.core;

import com.oregor.trinity.scaffolder.java.core.api.ApiClientRestScaffolder;
import com.oregor.trinity.scaffolder.java.core.api.ApiClientSubscriberScaffolder;
import com.oregor.trinity.scaffolder.java.core.api.ApiClientsScaffolder;
import com.oregor.trinity.scaffolder.java.core.api.ApiDetailScaffolder;
import com.oregor.trinity.scaffolder.java.core.api.ApiFamilyScaffolder;
import com.oregor.trinity.scaffolder.java.core.api.ApiScaffolder;
import com.oregor.trinity.scaffolder.java.core.application.AppScaffolder;
import com.oregor.trinity.scaffolder.java.core.aux.AuxDetailPublisherScaffolder;
import com.oregor.trinity.scaffolder.java.core.aux.AuxDetailsScaffolder;
import com.oregor.trinity.scaffolder.java.core.aux.AuxFamilyScaffolder;
import com.oregor.trinity.scaffolder.java.core.aux.AuxScaffolder;
import com.oregor.trinity.scaffolder.java.core.domain.DomainDetailsPersistenceRdbmsScaffolder;
import com.oregor.trinity.scaffolder.java.core.domain.DomainDetailsScaffolder;
import com.oregor.trinity.scaffolder.java.core.domain.DomainFamilyScaffolder;
import com.oregor.trinity.scaffolder.java.core.domain.DomainModelScaffolder;
import com.oregor.trinity.scaffolder.java.core.domain.DomainServicesScaffolder;
import com.oregor.trinity.scaffolder.java.core.project.GitIgnoreScaffolder;
import com.oregor.trinity.scaffolder.java.core.project.MavenParentPomScaffolder;
import com.oregor.trinity.scaffolder.java.core.project.MavenSettingsScaffolder;
import com.oregor.trinity.scaffolder.java.core.project.ProjectFamilyScaffolder;
import com.oregor.trinity.scaffolder.java.core.project.RootScaffolder;
import com.oregor.trinity.scaffolder.java.freemarker.FreemarkerConfig;
import com.oregor.trinity.scaffolder.java.freemarker.FreemarkerService;

/**
 * The type Trinity scaffolder java factory.
 *
 * @author Christos Tsakostas
 */
public class TrinityScaffolderJavaFactory {

  // ===============================================================================================
  // SINGLETONS / STATIC
  // ===============================================================================================
  private static ProjectFamilyScaffolder projectFamilyScaffolder;
  private static AppScaffolder appScaffolder;
  private static ApiFamilyScaffolder apiFamilyScaffolder;
  private static AuxFamilyScaffolder auxFamilyScaffolder;
  private static DomainFamilyScaffolder domainFamilyScaffolder;

  static {
    FreemarkerService freemarkerService =
        new FreemarkerService(FreemarkerConfig.getInstance().getConfiguration());

    projectFamilyScaffolder =
        new ProjectFamilyScaffolder(
            freemarkerService,
            new GitIgnoreScaffolder(freemarkerService),
            new MavenParentPomScaffolder(freemarkerService),
            new MavenSettingsScaffolder(freemarkerService),
            new RootScaffolder(freemarkerService));

    appScaffolder = new AppScaffolder(freemarkerService);

    apiFamilyScaffolder =
        new ApiFamilyScaffolder(
            freemarkerService,
            new ApiScaffolder(freemarkerService),
            new ApiDetailScaffolder(freemarkerService),
            new ApiClientsScaffolder(freemarkerService),
            new ApiClientRestScaffolder(freemarkerService),
            new ApiClientSubscriberScaffolder(freemarkerService));

    auxFamilyScaffolder =
        new AuxFamilyScaffolder(
            freemarkerService,
            new AuxScaffolder(freemarkerService),
            new AuxDetailsScaffolder(freemarkerService),
            new AuxDetailPublisherScaffolder(freemarkerService));

    domainFamilyScaffolder =
        new DomainFamilyScaffolder(
            freemarkerService,
            new DomainModelScaffolder(freemarkerService),
            new DomainDetailsScaffolder(freemarkerService),
            new DomainServicesScaffolder(freemarkerService),
            new DomainDetailsPersistenceRdbmsScaffolder(freemarkerService));
  }

  // ===============================================================================================
  // CONSTRUCTORS
  // ===============================================================================================

  private TrinityScaffolderJavaFactory() {
    super();
  }

  // ===============================================================================================
  // FACTORY
  // ===============================================================================================

  /**
   * New instance trinity scaffolder java.
   *
   * @return the trinity scaffolder java
   */
  public static TrinityScaffolderJava newInstance() {
    return new TrinityScaffolderJava(
        projectFamilyScaffolder,
        appScaffolder,
        apiFamilyScaffolder,
        auxFamilyScaffolder,
        domainFamilyScaffolder);
  }
}
