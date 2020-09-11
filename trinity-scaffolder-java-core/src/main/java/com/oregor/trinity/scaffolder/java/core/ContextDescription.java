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

import java.util.Objects;

/**
 * The type Context description.
 *
 * @author Christos Tsakostas
 */
public class ContextDescription {

  // ===============================================================================================
  // STATE
  // ===============================================================================================

  private String contextFolder;
  private String contextName;
  private String groupId;
  private String artifactId;
  private String modulePrefix;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Context description.
   *
   * @param contextFolder the context folder
   * @param contextName the context name
   * @param groupId the group id
   * @param artifactId the artifact id
   * @param modulePrefix the module prefix
   */
  public ContextDescription(
      String contextFolder,
      String contextName,
      String groupId,
      String artifactId,
      String modulePrefix) {
    setContextFolder(contextFolder);
    setContextName(contextName);
    setGroupId(groupId);
    setArtifactId(artifactId);
    setModulePrefix(modulePrefix);
  }

  // ===============================================================================================
  // GETTERS
  // ===============================================================================================

  /**
   * Gets context folder.
   *
   * @return the context folder
   */
  public String getContextFolder() {
    return contextFolder;
  }

  /**
   * Gets context name.
   *
   * @return the context name
   */
  public String getContextName() {
    return contextName;
  }

  /**
   * Gets group id.
   *
   * @return the group id
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * Gets artifact id.
   *
   * @return the artifact id
   */
  public String getArtifactId() {
    return artifactId;
  }

  /**
   * Gets module prefix.
   *
   * @return the module prefix
   */
  public String getModulePrefix() {
    return modulePrefix;
  }

  // ===============================================================================================
  // SETTERS
  // ===============================================================================================

  /**
   * Sets context folder.
   *
   * @param contextFolder the context folder
   */
  private void setContextFolder(String contextFolder) {
    this.contextFolder = contextFolder;
  }

  /**
   * Sets context name.
   *
   * @param contextName the context name
   */
  private void setContextName(String contextName) {
    this.contextName = contextName;
  }

  /**
   * Sets group id.
   *
   * @param groupId the group id
   */
  private void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  /**
   * Sets artifact id.
   *
   * @param artifactId the artifact id
   */
  private void setArtifactId(String artifactId) {
    this.artifactId = artifactId;
  }

  /**
   * Sets module prefix.
   *
   * @param modulePrefix the module prefix
   */
  private void setModulePrefix(String modulePrefix) {
    if (!modulePrefix.endsWith("-")) {
      this.modulePrefix = modulePrefix + "-";
    } else {
      this.modulePrefix = modulePrefix;
    }
  }

  // ===============================================================================================
  // OVERRIDES
  // ===============================================================================================

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContextDescription that = (ContextDescription) o;
    return Objects.equals(contextFolder, that.contextFolder)
        && Objects.equals(contextName, that.contextName)
        && Objects.equals(groupId, that.groupId)
        && Objects.equals(artifactId, that.artifactId)
        && Objects.equals(modulePrefix, that.modulePrefix);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contextFolder, contextName, groupId, artifactId, modulePrefix);
  }
}
