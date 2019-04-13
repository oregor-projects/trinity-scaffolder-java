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

package com.oregor.trinity.scaffolder.java.freemarker;

import freemarker.cache.ClassTemplateLoader;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModelException;

/**
 * The type Freemarker config.
 *
 * @author Christos Tsakostas
 */
public class FreemarkerConfig {

  private Configuration configuration;

  // ===============================================================================================
  // SINGLETON
  // ===============================================================================================
  private static final FreemarkerConfig instance;

  static {
    instance = new FreemarkerConfig();
  }

  /**
   * Gets the FreemarkerConfig instance.
   *
   * @return the instance
   */
  public static FreemarkerConfig getInstance() {
    return instance;
  }

  // ===============================================================================================
  // CONSTRUCTOR(S)
  // ===============================================================================================

  /** Instantiates a new Freemarker config. */
  private FreemarkerConfig() {
    configuration = new Configuration(Configuration.VERSION_2_3_28);
    configuration.setTemplateLoader(new ClassTemplateLoader(this.getClass(), "/ftl"));
    configuration.setDefaultEncoding("UTF-8");
    configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    configuration.setLogTemplateExceptions(false);
    configuration.setWrapUncheckedExceptions(true);

    setAuthorService(configuration);
  }

  // ===============================================================================================
  // GETTERS
  // ===============================================================================================

  /**
   * Gets configuration.
   *
   * @return the configuration
   */
  public Configuration getConfiguration() {
    return configuration;
  }

  // ===============================================================================================
  // PRIVATE
  // ===============================================================================================

  /**
   * Sets author service.
   *
   * @param configuration the configuration
   */
  private void setAuthorService(Configuration configuration) {
    BeansWrapper wrapper = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_28).build();
    TemplateHashModel staticModels = wrapper.getStaticModels();
    try {
      TemplateHashModel templateHashModelTextConverter =
          (TemplateHashModel)
              staticModels.get(
                  "com.oregor.trinity.scaffolder.java.freemarker.FreemarkerAuthorService");
      configuration.setSharedVariable("authorService", templateHashModelTextConverter);
    } catch (TemplateModelException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }
  }
}
