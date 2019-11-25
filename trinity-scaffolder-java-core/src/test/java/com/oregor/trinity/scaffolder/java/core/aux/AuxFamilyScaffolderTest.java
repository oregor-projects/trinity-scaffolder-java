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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.oregor.trinity.scaffolder.java.core.AbstractTrinityScaffolderJavaTest;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Aux family scaffolder test.
 *
 * @author Christos Tsakostas
 */
public class AuxFamilyScaffolderTest extends AbstractTrinityScaffolderJavaTest {

  private AuxScaffolder auxScaffolder;
  private AuxDetailsScaffolder auxDetailsScaffolder;
  private AuxFamilyScaffolder auxFamilyScaffolder;
  private AuxDetailPropertyFileScaffolder auxDetailPropertyFileScaffolder;
  private AuxDetailAlertSlackScaffolder auxDetailAlertSlackScaffolder;

  /** Sets up. */
  @Before
  public void setUp() {
    auxScaffolder = mock(AuxScaffolder.class);
    auxDetailsScaffolder = mock(AuxDetailsScaffolder.class);
    auxDetailPropertyFileScaffolder = mock(AuxDetailPropertyFileScaffolder.class);
    auxDetailAlertSlackScaffolder = mock(AuxDetailAlertSlackScaffolder.class);

    auxFamilyScaffolder =
        new AuxFamilyScaffolder(
            freemarkerService,
            auxScaffolder,
            auxDetailsScaffolder,
            auxDetailPropertyFileScaffolder,
            auxDetailAlertSlackScaffolder);
  }

  /** Should scaffold successfully. */
  @Test
  public void shouldScaffoldSuccessfully() {
    auxFamilyScaffolder.scaffold(generationPath(), projectDescription(), dataModel());

    verify(auxScaffolder)
        .scaffold(generationPath(), contextDescription(), dataModelWithContextDescription());
    verify(auxDetailsScaffolder)
        .scaffold(generationPath(), contextDescription(), dataModelWithContextDescription());
  }
}
