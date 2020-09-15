/*-
 * ==========================LICENSE_START=================================
 * Trinity Scaffolder for Java Applications
 * ========================================================================
 * Copyright (C) 2019 - 2020 Christos Tsakostas, OREGOR
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

/** The type Enablement. */
public class Enablement {

  // ===============================================================================================
  // STATE
  // ===============================================================================================

  private boolean apiClientBatchProcessScaffolder = true;
  private boolean apiClientBatchProcessActiveMqScaffolder = true;
  private boolean auxDetailPropertyFileScaffolder = true;
  private boolean auxDetailAlertSlackScaffolder = true;
  private boolean domainDetailRepositoryInMemoryScaffolder = true;

  // ===============================================================================================
  // GETTERS
  // ===============================================================================================

  /**
   * Is api client batch process scaffolder boolean.
   *
   * @return the boolean
   */
  public boolean isApiClientBatchProcessScaffolder() {
    return apiClientBatchProcessScaffolder;
  }

  /**
   * Is api client batch process active mq scaffolder boolean.
   *
   * @return the boolean
   */
  public boolean isApiClientBatchProcessActiveMqScaffolder() {
    return apiClientBatchProcessActiveMqScaffolder;
  }

  /**
   * Is aux detail property file scaffolder boolean.
   *
   * @return the boolean
   */
  public boolean isAuxDetailPropertyFileScaffolder() {
    return auxDetailPropertyFileScaffolder;
  }

  /**
   * Is aux detail alert slack scaffolder boolean.
   *
   * @return the boolean
   */
  public boolean isAuxDetailAlertSlackScaffolder() {
    return auxDetailAlertSlackScaffolder;
  }

  /**
   * Is domain detail repository in memory scaffolder boolean.
   *
   * @return the boolean
   */
  public boolean isDomainDetailRepositoryInMemoryScaffolder() {
    return domainDetailRepositoryInMemoryScaffolder;
  }

  // ===============================================================================================
  // SETTERS
  // ===============================================================================================

  /**
   * Sets api client batch process scaffolder.
   *
   * @param apiClientBatchProcessScaffolder the api client batch process scaffolder
   */
  public void setApiClientBatchProcessScaffolder(boolean apiClientBatchProcessScaffolder) {
    this.apiClientBatchProcessScaffolder = apiClientBatchProcessScaffolder;
  }

  /**
   * Sets api client batch process active mq scaffolder.
   *
   * @param apiClientBatchProcessActiveMqScaffolder the api client batch process active mq
   *     scaffolder
   */
  public void setApiClientBatchProcessActiveMqScaffolder(
      boolean apiClientBatchProcessActiveMqScaffolder) {
    this.apiClientBatchProcessActiveMqScaffolder = apiClientBatchProcessActiveMqScaffolder;
  }

  /**
   * Sets aux detail property file scaffolder.
   *
   * @param auxDetailPropertyFileScaffolder the aux detail property file scaffolder
   */
  public void setAuxDetailPropertyFileScaffolder(boolean auxDetailPropertyFileScaffolder) {
    this.auxDetailPropertyFileScaffolder = auxDetailPropertyFileScaffolder;
  }

  /**
   * Sets aux detail alert slack scaffolder.
   *
   * @param auxDetailAlertSlackScaffolder the aux detail alert slack scaffolder
   */
  public void setAuxDetailAlertSlackScaffolder(boolean auxDetailAlertSlackScaffolder) {
    this.auxDetailAlertSlackScaffolder = auxDetailAlertSlackScaffolder;
  }

  /**
   * Sets domain detail repository in memory scaffolder.
   *
   * @param domainDetailRepositoryInMemoryScaffolder the domain detail repository in memory
   *     scaffolder
   */
  public void setDomainDetailRepositoryInMemoryScaffolder(
      boolean domainDetailRepositoryInMemoryScaffolder) {
    this.domainDetailRepositoryInMemoryScaffolder = domainDetailRepositoryInMemoryScaffolder;
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
    Enablement that = (Enablement) o;
    return apiClientBatchProcessScaffolder == that.apiClientBatchProcessScaffolder
        && apiClientBatchProcessActiveMqScaffolder == that.apiClientBatchProcessActiveMqScaffolder
        && auxDetailPropertyFileScaffolder == that.auxDetailPropertyFileScaffolder
        && auxDetailAlertSlackScaffolder == that.auxDetailAlertSlackScaffolder
        && domainDetailRepositoryInMemoryScaffolder
            == that.domainDetailRepositoryInMemoryScaffolder;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        apiClientBatchProcessScaffolder,
        apiClientBatchProcessActiveMqScaffolder,
        auxDetailPropertyFileScaffolder,
        auxDetailAlertSlackScaffolder,
        domainDetailRepositoryInMemoryScaffolder);
  }
}
