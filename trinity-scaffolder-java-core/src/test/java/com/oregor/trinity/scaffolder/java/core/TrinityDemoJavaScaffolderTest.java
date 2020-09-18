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

package com.oregor.trinity.scaffolder.java.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashSet;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

/**
 * The type Trinity demo java scaffolder java test.
 *
 * @author Christos Tsakostas
 */
public class TrinityDemoJavaScaffolderTest {

  private static final String EXPORT_PATH = "tmp";

  private static final String TEST_PATH = "./src/test/resources/trinity-demo-java";
  private static final String PREFIX = "demo";

  /** Should scaffold successfully. */
  @Test
  public void shouldScaffoldSuccessfully() throws IOException {
    FileUtils.deleteDirectory(new File(EXPORT_PATH));

    TrinityScaffolderJava trinityScaffolderJava = TrinityScaffolderJavaFactory.newInstance();

    trinityScaffolderJava.scaffold(Paths.get(EXPORT_PATH), trinityDemoProjectDescription());

    String pathProject = EXPORT_PATH + "/" + trinityDemoProjectDescription().getProjectFolder();

    // TODO: is this useful?
    //    assertThat(contentOf(new File(pathProject + "/" + PREFIX + "-api/pom.xml")))
    //        .isEqualTo(contentOf(new File(TEST_PATH + "/" + PREFIX + "-api/pom.xml")));
    //
    //    assertThat(contentOf(new File(pathProject + "/" + PREFIX + "-api-clients/pom.xml")))
    //        .isEqualTo(contentOf(new File(TEST_PATH + "/" + PREFIX + "-api-clients/pom.xml")));
    //
    //    assertThat(contentOf(new File(pathProject + "/" + PREFIX + "-api-detail/pom.xml")))
    //        .isEqualTo(contentOf(new File(TEST_PATH + "/" + PREFIX + "-api-detail/pom.xml")));
    //
    //    assertThat(contentOf(new File(pathProject + "/" + PREFIX + "-aux/pom.xml")))
    //        .isEqualTo(contentOf(new File(TEST_PATH + "/" + PREFIX + "-aux/pom.xml")));
    //
    //    assertThat(contentOf(new File(pathProject + "/" + PREFIX + "-aux-details/pom.xml")))
    //        .isEqualTo(contentOf(new File(TEST_PATH + "/" + PREFIX + "-aux-details/pom.xml")));
    //
    //    assertThat(contentOf(new File(pathProject + "/" + PREFIX + "-domain/pom.xml")))
    //        .isEqualTo(contentOf(new File(TEST_PATH + "/" + PREFIX + "-domain/pom.xml")));
    //
    //    assertThat(contentOf(new File(pathProject + "/" + PREFIX + "-domain-details/pom.xml")))
    //        .isEqualTo(contentOf(new File(TEST_PATH + "/" + PREFIX + "-domain-details/pom.xml")));

    // assertThat(contentOf(new File(pathProject + "/pom.xml")))
    //    .isEqualTo(contentOf(new File(TEST_PATH + "/pom.xml")));

    // assertThat(contentOf(new File(pathProject + "/" + PREFIX + "-app/pom.xml")))
    //    .isEqualTo(contentOf(new File(TEST_PATH + "/" + PREFIX + "-app/pom.xml")));

    assertThat(
            contentOf(
                new File(pathProject + "/" + PREFIX + "-app/src/main/resources/application.yml")))
        .isEqualTo(
            contentOf(
                new File(TEST_PATH + "/" + PREFIX + "-app/src/main/resources/application.yml")));
  }

  private ProjectDescription trinityDemoProjectDescription() {
    return new ProjectDescriptionBuilder()
        .setProjectFolder("trinity-demo-java")
        .setContext("demo")
        .setGroupId("com.oregor.trinity.demo.java")
        .setArtifactId("trinity-demo-java")
        .setVersion("0.0.1")
        .setModulePrefix("demo")
        .setName("trinity-demo-java")
        .setDescription("trinity-demo-java")
        .setUrl("https://www.oregor.com")
        .setInceptionYear("2019")
        .setOrganizationName("OREGOR LP")
        .setOrganizationUrl("https://www.oregor.com")
        .setLicenseName("The Apache License, Version 2.0")
        .setScmConnection("scm:git:git://github.com/oregor-projects/trinity-demo-java.git")
        .setScmDeveloperConnection("scm:git:git@github.com:oregor-projects/trinity-demo-java.git")
        .setScmUrl("http://github.com/oregor-projects/trinity-demo-java/tree/master")
        .setDistributionProfile("ossrh-oregor")
        .setExtraModules(new LinkedHashSet<>(Arrays.asList("tools")))
        .setEnablement(new Enablement())
        .createProjectDescription();
  }
}
