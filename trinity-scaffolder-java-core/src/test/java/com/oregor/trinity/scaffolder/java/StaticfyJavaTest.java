/*-
 * ==========================LICENSE_START=================================
 * PolyGenesis Platform
 * ========================================================================
 * Copyright (C) 2015 - 2019 Christos Tsakostas, OREGOR LTD
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

package com.oregor.trinity.scaffolder.java;

import static org.assertj.core.api.Assertions.assertThatCode;

import com.oregor.trinity.scaffolder.java.core.ProjectDescription;
import com.oregor.trinity.scaffolder.java.core.ProjectDescriptionBuilder;
import com.oregor.trinity.scaffolder.java.core.TrinityScaffolderJava;
import com.oregor.trinity.scaffolder.java.core.TrinityScaffolderJavaFactory;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Ignore;
import org.junit.Test;

/** @author Christos Tsakostas */
@Ignore
public class StaticfyJavaTest {

  private static final String JAVA_EXPORT_PATH = "/Users/tsakostas/work/repo/github/oregor/xxx";
  private static final String JAVA_ROOT_PACKAGE = "com.oregor.staticfy";
  private static final String JAVA_PROJECT_FOLDER = "staticfy";
  private static final String JAVA_MODULE_PREFIX = "staticfy";

  @Test
  public void shouldScaffoldAndGenerateSuccessfully() throws IOException {
    //    FileUtils.deleteDirectory(new File(JAVA_EXPORT_PATH));
    TrinityScaffolderJava trinityScaffolderJava = TrinityScaffolderJavaFactory.newInstance();

    assertThatCode(
            () -> trinityScaffolderJava.scaffold(Paths.get(JAVA_EXPORT_PATH), projectDescription()))
        .doesNotThrowAnyException();

    //    assertThatCode(() -> generate()).doesNotThrowAnyException();
  }

  // ===============================================================================================
  // PRIVATE
  // ===============================================================================================

  private ProjectDescription projectDescription() {
    Set<String> extraModules = new LinkedHashSet<>();
    extraModules.add("staticfy-cli");
    extraModules.add("staticfy-core");

    return new ProjectDescriptionBuilder()
        .setProjectFolder(JAVA_PROJECT_FOLDER)
        .setGroupId(JAVA_ROOT_PACKAGE)
        .setArtifactId("staticfy")
        .setVersion("0.0.1-SNAPSHOT")
        .setModulePrefix(JAVA_MODULE_PREFIX)
        .setName("staticfy")
        .setDescription("staticfy")
        .setUrl("https://www.oregor.com")
        .setInceptionYear("2020")
        .setOrganizationName("Christos Tsakostas, OREGOR LTD")
        .setOrganizationUrl("https://www.oregor.com")
        .setLicenseName("The Apache License, Version 2.0")
        .setScmConnection("scm:git:git://github.com/oregor-projects/staticfy.git")
        .setScmDeveloperConnection("scm:git:git@github.com:oregor-projects/staticfy.git")
        .setScmUrl("http://github.com/oregor-projects/staticfy/tree/master")
        .setDistributionProfile("ossrh-oregor")
        .setExtraModules(extraModules)
        .createProjectDescription();
  }
}
