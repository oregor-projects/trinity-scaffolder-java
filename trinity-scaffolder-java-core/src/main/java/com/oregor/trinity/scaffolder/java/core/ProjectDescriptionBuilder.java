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

package com.oregor.trinity.scaffolder.java.core;

import com.oregor.trinity.scaffolder.java.assertion.Assertion;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The type Project description builder.
 *
 * @author Christos Tsakostas
 */
public class ProjectDescriptionBuilder {

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
  private Set<String> extraModules = new LinkedHashSet<>();

  /**
   * Sets context.
   *
   * @param context the context
   * @return the context
   */
  public ProjectDescriptionBuilder setContext(String context) {
    this.context = context;
    return this;
  }

  /**
   * Sets table prefix.
   *
   * @param tablePrefix the table prefix
   * @return the table prefix
   */
  public ProjectDescriptionBuilder setTablePrefix(String tablePrefix) {
    this.tablePrefix = tablePrefix;
    return this;
  }

  /**
   * Sets group id.
   *
   * @param groupId the group id
   * @return the group id
   */
  public ProjectDescriptionBuilder setGroupId(String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * Sets artifact id.
   *
   * @param artifactId the artifact id
   * @return the artifact id
   */
  public ProjectDescriptionBuilder setArtifactId(String artifactId) {
    this.artifactId = artifactId;
    return this;
  }

  /**
   * Sets module prefix.
   *
   * @param modulePrefix the module prefix
   * @return the module prefix
   */
  public ProjectDescriptionBuilder setModulePrefix(String modulePrefix) {
    this.modulePrefix = modulePrefix;
    return this;
  }

  /**
   * Sets version.
   *
   * @param version the version
   * @return the version
   */
  public ProjectDescriptionBuilder setVersion(String version) {
    this.version = version;
    return this;
  }

  /**
   * Sets name.
   *
   * @param name the name
   * @return the name
   */
  public ProjectDescriptionBuilder setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Sets description.
   *
   * @param description the description
   * @return the description
   */
  public ProjectDescriptionBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  /**
   * Sets url.
   *
   * @param url the url
   * @return the url
   */
  public ProjectDescriptionBuilder setUrl(String url) {
    this.url = url;
    return this;
  }

  /**
   * Sets inception year.
   *
   * @param inceptionYear the inception year
   * @return the inception year
   */
  public ProjectDescriptionBuilder setInceptionYear(String inceptionYear) {
    this.inceptionYear = inceptionYear;
    return this;
  }

  /**
   * Sets organization name.
   *
   * @param organizationName the organization name
   * @return the organization name
   */
  public ProjectDescriptionBuilder setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
    return this;
  }

  /**
   * Sets organization url.
   *
   * @param organizationUrl the organization url
   * @return the organization url
   */
  public ProjectDescriptionBuilder setOrganizationUrl(String organizationUrl) {
    this.organizationUrl = organizationUrl;
    return this;
  }

  /**
   * Sets license name.
   *
   * @param licenseName the license name
   * @return the license name
   */
  public ProjectDescriptionBuilder setLicenseName(String licenseName) {
    this.licenseName = licenseName;
    return this;
  }

  /**
   * Sets license url.
   *
   * @param licenseUrl the license url
   * @return the license url
   */
  public ProjectDescriptionBuilder setLicenseUrl(String licenseUrl) {
    this.licenseUrl = licenseUrl;
    return this;
  }

  /**
   * Sets scm connection.
   *
   * @param scmConnection the scm connection
   * @return the scm connection
   */
  public ProjectDescriptionBuilder setScmConnection(String scmConnection) {
    this.scmConnection = scmConnection;
    return this;
  }

  /**
   * Sets scm developer connection.
   *
   * @param scmDeveloperConnection the scm developer connection
   * @return the scm developer connection
   */
  public ProjectDescriptionBuilder setScmDeveloperConnection(String scmDeveloperConnection) {
    this.scmDeveloperConnection = scmDeveloperConnection;
    return this;
  }

  /**
   * Sets scm url.
   *
   * @param scmUrl the scm url
   * @return the scm url
   */
  public ProjectDescriptionBuilder setScmUrl(String scmUrl) {
    this.scmUrl = scmUrl;
    return this;
  }

  /**
   * Sets distribution profile.
   *
   * @param distributionProfile the distribution profile
   * @return the distribution profile
   */
  public ProjectDescriptionBuilder setDistributionProfile(String distributionProfile) {
    this.distributionProfile = distributionProfile;
    return this;
  }

  /**
   * Sets extra modules.
   *
   * @param extraModules the extra modules
   * @return the extra modules
   */
  public ProjectDescriptionBuilder setExtraModules(Set<String> extraModules) {
    this.extraModules = extraModules;
    return this;
  }

  /**
   * Create project description project description.
   *
   * @return the project description
   */
  public ProjectDescription createProjectDescription() {
    Assertion.isNotNull(context, "context is required");
    Assertion.isNotNull(groupId, "groupId is required");
    Assertion.isNotNull(artifactId, "artifactId is required");
    Assertion.isNotNull(version, "version is required");
    Assertion.isNotNull(modulePrefix, "modulePrefix is required");
    Assertion.isNotNull(name, "name is required");
    Assertion.isNotNull(description, "description is required");
    Assertion.isNotNull(url, "url is required");
    Assertion.isNotNull(inceptionYear, "inceptionYear is required");
    Assertion.isNotNull(organizationName, "organizationName is required");
    Assertion.isNotNull(organizationUrl, "organizationUrl is required");
    Assertion.isNotNull(licenseName, "licenseName is required");
    Assertion.isNotNull(scmConnection, "scmConnection is required");
    Assertion.isNotNull(scmDeveloperConnection, "scmDeveloperConnection is required");
    Assertion.isNotNull(scmUrl, "scmUrl is required");
    Assertion.isNotNull(distributionProfile, "distributionProfile is required");

    return new ProjectDescription(
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
