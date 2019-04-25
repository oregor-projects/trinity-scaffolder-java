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

package com.oregor.trinity.scaffolder.java;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;
import org.junit.Test;

/** @author Christos Tsakostas */
public class TrinityScaffolderJavaLauncherTest {

  @Test
  public void checkCorrectInputContents() throws FileNotFoundException {
    FileInputStream fileInputStream = new FileInputStream("src/test/resources/correct-input.txt");

    Scanner scanner = new Scanner(fileInputStream);

    String firstLine = "groupId";
    String scannerFirstLine = scanner.nextLine();
    assertThat(scannerFirstLine).isEqualTo(firstLine);

    String secondLine = "artifactId";
    String scannerSecondLine = scanner.nextLine();
    assertThat(scannerSecondLine).isEqualTo(secondLine);
  }

  @Test
  public void shouldRunSuccessfully() throws FileNotFoundException {
    FileInputStream fileInputStream = new FileInputStream("src/test/resources/correct-input.txt");

    Scanner scanner = new Scanner(fileInputStream);

    TrinityScaffolderJavaLauncher trinityScaffolderJavaLauncher =
        new TrinityScaffolderJavaLauncher(scanner);

    trinityScaffolderJavaLauncher.run(Paths.get("tmp"));
  }
}
