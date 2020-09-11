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

package com.oregor.trinity.scaffolder.java.core.project;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.oregor.trinity.scaffolder.java.core.AbstractTrinityScaffolderJavaTest;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Project family scaffolder test.
 *
 * @author Christos Tsakostas
 */
public class ProjectFamilyScaffolderTest extends AbstractTrinityScaffolderJavaTest {

  private GitIgnoreScaffolder gitIgnoreScaffolder;
  private MavenParentPomScaffolder mavenParentPomScaffolder;
  private MavenSettingsScaffolder mavenSettingsScaffolder;
  private RootScaffolder rootScaffolder;
  private ProjectFamilyScaffolder projectFamilyScaffolder;

  /** Sets up. */
  @Before
  public void setUp() {
    gitIgnoreScaffolder = mock(GitIgnoreScaffolder.class);
    mavenParentPomScaffolder = mock(MavenParentPomScaffolder.class);
    mavenSettingsScaffolder = mock(MavenSettingsScaffolder.class);
    rootScaffolder = mock(RootScaffolder.class);

    projectFamilyScaffolder =
        new ProjectFamilyScaffolder(
            freemarkerService,
            gitIgnoreScaffolder,
            mavenParentPomScaffolder,
            mavenSettingsScaffolder,
            rootScaffolder);
  }

  /** Should scaffold successfully. */
  @Test
  public void shouldScaffoldSuccessfully() {
    projectFamilyScaffolder.scaffold(generationPath(), projectDescription(), dataModel());

    verify(gitIgnoreScaffolder).scaffold(generationPath(), projectDescription(), dataModel());
    verify(mavenParentPomScaffolder).scaffold(generationPath(), projectDescription(), dataModel());
    verify(mavenSettingsScaffolder).scaffold(generationPath(), projectDescription(), dataModel());
    verify(rootScaffolder).scaffold(generationPath(), projectDescription(), dataModel());
  }
}
