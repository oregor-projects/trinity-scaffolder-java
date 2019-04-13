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

package com.oregor.trinity.scaffolder.java.core.application;

import static org.mockito.Mockito.verify;

import com.oregor.trinity.scaffolder.java.core.AbstractTrinityScaffolderJavaTest;
import java.nio.file.Paths;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * The type App scaffolder test.
 *
 * @author Christos Tsakostas
 */
@Ignore
public class AppScaffolderTest extends AbstractTrinityScaffolderJavaTest {

  private AppScaffolder appScaffolder;

  /** Sets up. */
  @Before
  public void setUp() {
    appScaffolder = new AppScaffolder(freemarkerService);
  }

  /** Should scaffold successfully. */
  @Test
  public void shouldScaffoldSuccessfully() {
    appScaffolder.scaffold(generationPath(), projectDescription(), dataModel());

    // TODO
    verify(freemarkerService)
        .export(
            dataModel(),
            "trinity-scaffolder-java/app/pom.xml.ftl",
            Paths.get(generationPath().toString(), "prefix-api", "pom.xml"));
  }
}
