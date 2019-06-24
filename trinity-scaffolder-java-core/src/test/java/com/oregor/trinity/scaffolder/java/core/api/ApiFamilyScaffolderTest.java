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

package com.oregor.trinity.scaffolder.java.core.api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.oregor.trinity.scaffolder.java.core.AbstractTrinityScaffolderJavaTest;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Api family scaffolder test.
 *
 * @author Christos Tsakostas
 */
public class ApiFamilyScaffolderTest extends AbstractTrinityScaffolderJavaTest {

  private ApiScaffolder apiScaffolder;
  private ApiDetailScaffolder apiDetailScaffolder;
  private ApiClientsScaffolder apiClientsScaffolder;
  private ApiClientRestScaffolder apiClientRestScaffolder;
  private ApiClientSchedulerScaffolder apiClientSchedulerScaffolder;
  private ApiClientSubscriberScaffolder apiClientSubscriberScaffolder;
  private ApiFamilyScaffolder apiFamilyScaffolder;
  private ApiClientSubscriberActiveMqScaffolder apiClientSubscriberActiveMqScaffolder;
  private ApiClientPeriodicProcessScaffolder apiClientPeriodicProcessScaffolder;
  private ApiClientPeriodicProcessTriggerActiveMqScaffolder
      apiClientPeriodicProcessTriggerActiveMqScaffolder;

  /** Sets up. */
  @Before
  public void setUp() {
    apiScaffolder = mock(ApiScaffolder.class);
    apiDetailScaffolder = mock(ApiDetailScaffolder.class);
    apiClientsScaffolder = mock(ApiClientsScaffolder.class);
    apiClientRestScaffolder = mock(ApiClientRestScaffolder.class);
    apiClientSchedulerScaffolder = mock(ApiClientSchedulerScaffolder.class);
    apiClientSubscriberScaffolder = mock(ApiClientSubscriberScaffolder.class);
    apiClientSubscriberActiveMqScaffolder = mock(ApiClientSubscriberActiveMqScaffolder.class);
    apiClientPeriodicProcessScaffolder = mock(ApiClientPeriodicProcessScaffolder.class);
    apiClientPeriodicProcessTriggerActiveMqScaffolder =
        mock(ApiClientPeriodicProcessTriggerActiveMqScaffolder.class);

    apiFamilyScaffolder =
        new ApiFamilyScaffolder(
            freemarkerService,
            apiScaffolder,
            apiDetailScaffolder,
            apiClientsScaffolder,
            apiClientRestScaffolder,
            apiClientSchedulerScaffolder,
            apiClientSubscriberScaffolder,
            apiClientSubscriberActiveMqScaffolder,
            apiClientPeriodicProcessScaffolder,
            apiClientPeriodicProcessTriggerActiveMqScaffolder);
  }

  /** Should scaffold successfully. */
  @Test
  public void shouldScaffoldSuccessfully() {
    apiFamilyScaffolder.scaffold(generationPath(), projectDescription(), dataModel());

    verify(apiScaffolder)
        .scaffold(generationPath(), contextDescription(), dataModelWithContextDescription());
    verify(apiDetailScaffolder)
        .scaffold(generationPath(), contextDescription(), dataModelWithContextDescription());
    verify(apiClientsScaffolder)
        .scaffold(generationPath(), contextDescription(), dataModelWithContextDescription());
    verify(apiClientRestScaffolder)
        .scaffold(generationPath(), contextDescription(), dataModelWithContextDescription());
    verify(apiClientSubscriberScaffolder)
        .scaffold(generationPath(), contextDescription(), dataModelWithContextDescription());
  }
}
