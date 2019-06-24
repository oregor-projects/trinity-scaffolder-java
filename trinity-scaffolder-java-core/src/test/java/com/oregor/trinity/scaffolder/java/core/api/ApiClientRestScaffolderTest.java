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

import static org.mockito.Mockito.verify;

import com.oregor.trinity.scaffolder.java.core.AbstractTrinityScaffolderJavaTest;
import java.nio.file.Paths;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Api client rest scaffolder test.
 *
 * @author Christos Tsakostas
 */
public class ApiClientRestScaffolderTest extends AbstractTrinityScaffolderJavaTest {

  private ApiClientRestScaffolder apiClientRestScaffolder;

  /** Sets up. */
  @Before
  public void setUp() {
    apiClientRestScaffolder = new ApiClientRestScaffolder(freemarkerService);
  }

  /** Should scaffold successfully. */
  @Test
  public void shouldScaffoldSuccessfully() {
    apiClientRestScaffolder.scaffold(generationPath(), contextDescription(), dataModel());

    verify(freemarkerService)
        .exportIfNotExists(
            dataModel(),
            "trinity-scaffolder-java/api-clients/api-client-rest-spring/pom.xml.ftl",
            Paths.get(
                generationPath().toString(),
                "prefix-api-clients",
                "prefix-api-client-rest-spring",
                "pom.xml"));
  }
}
