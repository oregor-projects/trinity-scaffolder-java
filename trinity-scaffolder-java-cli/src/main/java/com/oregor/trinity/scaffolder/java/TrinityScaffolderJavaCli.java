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

package com.oregor.trinity.scaffolder.java;

import java.nio.file.Paths;
import java.util.Scanner;

/**
 * The Trinity scaffolder CLI for Java projects.
 *
 * @author Christos Tsakostas
 */
public class TrinityScaffolderJavaCli {

  private static TrinityScaffolderJavaLauncher trinityScaffolderJavaLauncher =
      new TrinityScaffolderJavaLauncher(new Scanner(System.in));

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    trinityScaffolderJavaLauncher.run(Paths.get(""));
  }

  /**
   * Sets trinity scaffolder java launcher.
   *
   * @param trinityScaffolderJavaLauncher the trinity scaffolder java launcher
   */
  static void setTrinityScaffolderJavaLauncher(
      TrinityScaffolderJavaLauncher trinityScaffolderJavaLauncher) {
    TrinityScaffolderJavaCli.trinityScaffolderJavaLauncher = trinityScaffolderJavaLauncher;
  }
}
