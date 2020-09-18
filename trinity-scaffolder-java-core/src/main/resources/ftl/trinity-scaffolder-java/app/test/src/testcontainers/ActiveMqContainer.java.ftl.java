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

package ${ projectDescription.groupId }.testcontainers;

import org.testcontainers.containers.GenericContainer;

/**
 * The type Active mq container.
 *
 * @author Christos Tsakostas
 */
public class ActiveMqContainer extends GenericContainer<ActiveMqContainer> {

  private static final int ACTIVEMQ_PORT = 61616;

  /**
   * Instantiates a new Active mq container.
   *
   * @param image the image
   */
  public ActiveMqContainer(String image) {
    super(image);
    addExposedPort(ACTIVEMQ_PORT);
  }

  /**
   * Gets activemq port.
   *
   * @return the activemq port
   */
  public int getActivemqPort() {
    return ACTIVEMQ_PORT;
  }
}
