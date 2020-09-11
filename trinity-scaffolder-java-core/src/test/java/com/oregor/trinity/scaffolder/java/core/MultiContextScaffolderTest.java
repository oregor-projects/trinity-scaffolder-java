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

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

/**
 * The type Trinity demo java scaffolder java test.
 *
 * @author Christos Tsakostas
 */
public class MultiContextScaffolderTest {

  private static final String EXPORT_PATH = "tmp";

  /** Should scaffold successfully. */
  @Test
  public void shouldScaffoldSuccessfully() throws IOException {
    FileUtils.deleteDirectory(new File(EXPORT_PATH));

    TrinityScaffolderJava trinityScaffolderJava = TrinityScaffolderJavaFactory.newInstance();

    trinityScaffolderJava.scaffold(Paths.get(EXPORT_PATH), trinityDemoProjectDescription());
  }

  private ProjectDescription trinityDemoProjectDescription() {
    return new ProjectDescriptionBuilder()
        .setProjectFolder("multi-context")
        .setContext("demo")
        .setGroupId("com.oregor.some")
        .setArtifactId("multi-context")
        .setVersion("0.0.1")
        .setModulePrefix("myproject")
        .setName("multi-context")
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
        .setContextDescriptions(contextDescriptions())
        .createProjectDescription();
  }

  private Set<ContextDescription> contextDescriptions() {
    Set<ContextDescription> contextDescriptions = new LinkedHashSet<>();

    contextDescriptions.add(
        new ContextDescription(
            "access", "AccessContext", "com.oregor.some.access", "access", "access"));

    contextDescriptions.add(
        new ContextDescription("venue", "VenueContext", "com.oregor.some.venue", "venue", "venue"));

    return contextDescriptions;
  }
}
