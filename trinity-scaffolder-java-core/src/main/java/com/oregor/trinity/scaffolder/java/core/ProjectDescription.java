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

import java.util.Objects;
import java.util.Set;

/**
 * The type Project description.
 *
 * @author Christos Tsakostas
 */
public class ProjectDescription {

  private String context;
  private String tablePrefix;
  private String groupId;
  private String artifactId;
  private String modulePrefix;
  private String version;
  private String name;
  private String description;
  private String url;
  private String inceptionYear;
  private String organizationName;
  private String organizationUrl;
  private String licenseName;
  private String licenseUrl;
  private String scmConnection;
  private String scmDeveloperConnection;
  private String scmUrl;
  private String distributionProfile;
  private Set<String> extraModules;

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /**
   * Instantiates a new Project description.
   *
   * @param context the context
   * @param tablePrefix the table prefix
   * @param groupId the group id
   * @param artifactId the artifact id
   * @param modulePrefix the module prefix
   * @param version the version
   * @param name the name
   * @param description the description
   * @param url the url
   * @param inceptionYear the inception year
   * @param organizationName the organization name
   * @param organizationUrl the organization url
   * @param licenseName the license name
   * @param licenseUrl the license url
   * @param scmConnection the scm connection
   * @param scmDeveloperConnection the scm developer connection
   * @param scmUrl the scm url
   * @param distributionProfile the distribution profile
   * @param extraModules the extra modules
   */
  ProjectDescription(
      String context,
      String tablePrefix,
      String groupId,
      String artifactId,
      String modulePrefix,
      String version,
      String name,
      String description,
      String url,
      String inceptionYear,
      String organizationName,
      String organizationUrl,
      String licenseName,
      String licenseUrl,
      String scmConnection,
      String scmDeveloperConnection,
      String scmUrl,
      String distributionProfile,
      Set<String> extraModules) {
    this.context = context;
    this.tablePrefix = tablePrefix;
    this.groupId = groupId;
    this.artifactId = artifactId;
    this.modulePrefix = modulePrefix;
    this.version = version;
    this.name = name;
    this.description = description;
    this.url = url;
    this.inceptionYear = inceptionYear;
    this.organizationName = organizationName;
    this.organizationUrl = organizationUrl;
    this.licenseName = licenseName;
    this.licenseUrl = licenseUrl;
    this.scmConnection = scmConnection;
    this.scmDeveloperConnection = scmDeveloperConnection;
    this.scmUrl = scmUrl;
    this.distributionProfile = distributionProfile;
    this.extraModules = extraModules;
  }

  // ===============================================================================================
  // GETTERS
  // ===============================================================================================

  /**
   * Gets context.
   *
   * @return the context
   */
  public String getContext() {
    return context;
  }

  /**
   * Gets table prefix.
   *
   * @return the table prefix
   */
  public String getTablePrefix() {
    return tablePrefix;
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

  /**
   * Gets version.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets url.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets inception year.
   *
   * @return the inception year
   */
  public String getInceptionYear() {
    return inceptionYear;
  }

  /**
   * Gets organization name.
   *
   * @return the organization name
   */
  public String getOrganizationName() {
    return organizationName;
  }

  /**
   * Gets organization url.
   *
   * @return the organization url
   */
  public String getOrganizationUrl() {
    return organizationUrl;
  }

  /**
   * Gets license name.
   *
   * @return the license name
   */
  public String getLicenseName() {
    return licenseName;
  }

  /**
   * Gets license url.
   *
   * @return the license url
   */
  public String getLicenseUrl() {
    return licenseUrl;
  }

  /**
   * Gets scm connection.
   *
   * @return the scm connection
   */
  public String getScmConnection() {
    return scmConnection;
  }

  /**
   * Gets scm developer connection.
   *
   * @return the scm developer connection
   */
  public String getScmDeveloperConnection() {
    return scmDeveloperConnection;
  }

  /**
   * Gets scm url.
   *
   * @return the scm url
   */
  public String getScmUrl() {
    return scmUrl;
  }

  /**
   * Gets distribution profile.
   *
   * @return the distribution profile
   */
  public String getDistributionProfile() {
    return distributionProfile;
  }

  /**
   * Gets extra modules.
   *
   * @return the extra modules
   */
  public Set<String> getExtraModules() {
    return extraModules;
  }

  // ===============================================================================================
  // SETTERS
  // ===============================================================================================

  /**
   * Sets context.
   *
   * @param context the context
   */
  public void setContext(String context) {
    this.context = context;
  }

  /**
   * Sets table prefix.
   *
   * @param tablePrefix the table prefix
   */
  public void setTablePrefix(String tablePrefix) {
    this.tablePrefix = tablePrefix;
  }

  /**
   * Sets group id.
   *
   * @param groupId the group id
   */
  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  /**
   * Sets artifact id.
   *
   * @param artifactId the artifact id
   */
  public void setArtifactId(String artifactId) {
    this.artifactId = artifactId;
  }

  /**
   * Sets module prefix.
   *
   * @param modulePrefix the module prefix
   */
  public void setModulePrefix(String modulePrefix) {
    this.modulePrefix = modulePrefix;
  }

  /**
   * Sets version.
   *
   * @param version the version
   */
  public void setVersion(String version) {
    this.version = version;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Sets url.
   *
   * @param url the url
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * Sets inception year.
   *
   * @param inceptionYear the inception year
   */
  public void setInceptionYear(String inceptionYear) {
    this.inceptionYear = inceptionYear;
  }

  /**
   * Sets organization name.
   *
   * @param organizationName the organization name
   */
  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
  }

  /**
   * Sets organization url.
   *
   * @param organizationUrl the organization url
   */
  public void setOrganizationUrl(String organizationUrl) {
    this.organizationUrl = organizationUrl;
  }

  /**
   * Sets license name.
   *
   * @param licenseName the license name
   */
  public void setLicenseName(String licenseName) {
    this.licenseName = licenseName;
  }

  /**
   * Sets license url.
   *
   * @param licenseUrl the license url
   */
  public void setLicenseUrl(String licenseUrl) {
    this.licenseUrl = licenseUrl;
  }

  /**
   * Sets scm connection.
   *
   * @param scmConnection the scm connection
   */
  public void setScmConnection(String scmConnection) {
    this.scmConnection = scmConnection;
  }

  /**
   * Sets scm developer connection.
   *
   * @param scmDeveloperConnection the scm developer connection
   */
  public void setScmDeveloperConnection(String scmDeveloperConnection) {
    this.scmDeveloperConnection = scmDeveloperConnection;
  }

  /**
   * Sets scm url.
   *
   * @param scmUrl the scm url
   */
  public void setScmUrl(String scmUrl) {
    this.scmUrl = scmUrl;
  }

  /**
   * Sets distribution profile.
   *
   * @param distributionProfile the distribution profile
   */
  public void setDistributionProfile(String distributionProfile) {
    this.distributionProfile = distributionProfile;
  }

  /**
   * Sets extra modules.
   *
   * @param extraModules the extra modules
   */
  public void setExtraModules(Set<String> extraModules) {
    this.extraModules = extraModules;
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
    ProjectDescription that = (ProjectDescription) o;
    return Objects.equals(context, that.context)
        && Objects.equals(tablePrefix, that.tablePrefix)
        && Objects.equals(groupId, that.groupId)
        && Objects.equals(artifactId, that.artifactId)
        && Objects.equals(modulePrefix, that.modulePrefix)
        && Objects.equals(version, that.version)
        && Objects.equals(name, that.name)
        && Objects.equals(description, that.description)
        && Objects.equals(url, that.url)
        && Objects.equals(inceptionYear, that.inceptionYear)
        && Objects.equals(organizationName, that.organizationName)
        && Objects.equals(organizationUrl, that.organizationUrl)
        && Objects.equals(licenseName, that.licenseName)
        && Objects.equals(licenseUrl, that.licenseUrl)
        && Objects.equals(scmConnection, that.scmConnection)
        && Objects.equals(scmDeveloperConnection, that.scmDeveloperConnection)
        && Objects.equals(scmUrl, that.scmUrl)
        && Objects.equals(distributionProfile, that.distributionProfile)
        && Objects.equals(extraModules, that.extraModules);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        context,
        tablePrefix,
        groupId,
        artifactId,
        modulePrefix,
        version,
        name,
        description,
        url,
        inceptionYear,
        organizationName,
        organizationUrl,
        licenseName,
        licenseUrl,
        scmConnection,
        scmDeveloperConnection,
        scmUrl,
        distributionProfile,
        extraModules);
  }
}
