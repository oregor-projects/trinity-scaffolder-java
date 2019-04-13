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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;

import java.io.File;
import java.nio.file.Paths;
import org.junit.Test;

/**
 * The type Trinity scaffolder java test.
 *
 * @author Christos Tsakostas
 */
public class TrinityScaffolderJavaTest extends AbstractTrinityScaffolderJavaTest {

  private static final String EXPORT_PATH = "tmp";
  private static final String TEST_PATH = "./src/test/resources/test-project";
  private static final String PREFIX = "prefix";

  /** Should scaffold successfully. */
  @Test
  public void shouldScaffoldSuccessfully() {
    // TODO
    // FileUtils.deleteDirectory(new File(EXPORT_PATH));

    TrinityScaffolderJava trinityScaffolderJava = TrinityScaffolderJavaFactory.newInstance();

    trinityScaffolderJava.scaffold(Paths.get(EXPORT_PATH), projectDescription());

    String pathProject = EXPORT_PATH + "/" + projectDescription().getArtifactId();

    assertThat(contentOf(new File(pathProject + "/" + PREFIX + "-api/pom.xml")))
        .isEqualTo(contentOf(new File(TEST_PATH + "/" + PREFIX + "-api/pom.xml")));

    assertThat(contentOf(new File(pathProject + "/" + PREFIX + "-api-clients/pom.xml")))
        .isEqualTo(contentOf(new File(TEST_PATH + "/" + PREFIX + "-api-clients/pom.xml")));

    assertThat(contentOf(new File(pathProject + "/" + PREFIX + "-api-detail/pom.xml")))
        .isEqualTo(contentOf(new File(TEST_PATH + "/" + PREFIX + "-api-detail/pom.xml")));

    assertThat(contentOf(new File(pathProject + "/" + PREFIX + "-aux/pom.xml")))
        .isEqualTo(contentOf(new File(TEST_PATH + "/" + PREFIX + "-aux/pom.xml")));

    assertThat(contentOf(new File(pathProject + "/" + PREFIX + "-aux-details/pom.xml")))
        .isEqualTo(contentOf(new File(TEST_PATH + "/" + PREFIX + "-aux-details/pom.xml")));

    assertThat(contentOf(new File(pathProject + "/" + PREFIX + "-domain/pom.xml")))
        .isEqualTo(contentOf(new File(TEST_PATH + "/" + PREFIX + "-domain/pom.xml")));

    assertThat(contentOf(new File(pathProject + "/" + PREFIX + "-domain-details/pom.xml")))
        .isEqualTo(contentOf(new File(TEST_PATH + "/" + PREFIX + "-domain-details/pom.xml")));

    assertThat(contentOf(new File(pathProject + "/pom.xml")))
        .isEqualTo(contentOf(new File(TEST_PATH + "/pom.xml")));

    assertThat(contentOf(new File(pathProject + "/" + PREFIX + "-app/pom.xml")))
        .isEqualTo(contentOf(new File(TEST_PATH + "/" + PREFIX + "-app/pom.xml")));

    assertThat(
            contentOf(
                new File(pathProject + "/" + PREFIX + "-app/src/main/resources/application.yml")))
        .isEqualTo(
            contentOf(
                new File(TEST_PATH + "/" + PREFIX + "-app/src/main/resources/application.yml")));
  }
}
