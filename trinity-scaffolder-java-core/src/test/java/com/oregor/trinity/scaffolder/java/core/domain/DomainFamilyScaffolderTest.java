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

package com.oregor.trinity.scaffolder.java.core.domain;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.oregor.trinity.scaffolder.java.core.AbstractTrinityScaffolderJavaTest;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Domain family scaffolder test.
 *
 * @author Christos Tsakostas
 */
public class DomainFamilyScaffolderTest extends AbstractTrinityScaffolderJavaTest {

  private DomainModelScaffolder domainModelScaffolder;
  private DomainDetailsScaffolder domainDetailsScaffolder;
  private DomainDetailServicesScaffolder domainDetailServicesScaffolder;
  private DomainDetailRepositoryInMemoryScaffolder domainDetailRepositoryInMemoryScaffolder;
  private DomainDetailRepositorySpringDataJpaScaffolder
      domainDetailRepositorySpringDataJpaScaffolder;
  private DomainDetailScheduledPublisherScaffolder domainDetailScheduledPublisherScaffolder;
  private DomainFamilyScaffolder domainFamilyScaffolder;

  /** Sets up. */
  @Before
  public void setUp() {
    domainModelScaffolder = mock(DomainModelScaffolder.class);
    domainDetailsScaffolder = mock(DomainDetailsScaffolder.class);
    domainDetailServicesScaffolder = mock(DomainDetailServicesScaffolder.class);
    domainDetailRepositoryInMemoryScaffolder = mock(DomainDetailRepositoryInMemoryScaffolder.class);
    domainDetailRepositorySpringDataJpaScaffolder =
        mock(DomainDetailRepositorySpringDataJpaScaffolder.class);
    domainDetailScheduledPublisherScaffolder = mock(DomainDetailScheduledPublisherScaffolder.class);

    domainFamilyScaffolder =
        new DomainFamilyScaffolder(
            freemarkerService,
            domainModelScaffolder,
            domainDetailsScaffolder,
            domainDetailServicesScaffolder,
            domainDetailRepositoryInMemoryScaffolder,
            domainDetailRepositorySpringDataJpaScaffolder,
            domainDetailScheduledPublisherScaffolder);
  }

  /** Should scaffold successfully. */
  @Test
  public void shouldScaffoldSuccessfully() {
    domainFamilyScaffolder.scaffold(generationPath(), projectDescription(), dataModel());

    verify(domainModelScaffolder)
        .scaffold(generationPath(), contextDescription(), dataModelWithContextDescription());
    verify(domainDetailsScaffolder)
        .scaffold(generationPath(), contextDescription(), dataModelWithContextDescription());
    verify(domainDetailServicesScaffolder)
        .scaffold(generationPath(), contextDescription(), dataModelWithContextDescription());
    verify(domainDetailRepositorySpringDataJpaScaffolder)
        .scaffold(generationPath(), contextDescription(), dataModelWithContextDescription());
  }
}
