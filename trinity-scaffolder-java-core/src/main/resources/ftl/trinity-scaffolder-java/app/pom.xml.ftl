<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xmlns="http://maven.apache.org/POM/4.0.0"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <parent>
    <groupId>${ projectDescription.groupId }</groupId>
    <artifactId>${ projectDescription.artifactId }</artifactId>
    <version>${ projectDescription.version }</version>
  </parent>
  <modelVersion>4.0.0</modelVersion>

  <groupId>${ projectDescription.groupId }</groupId>
  <artifactId>${ projectDescription.modulePrefix }app</artifactId>

  <dependencies>
    <!-- ======================================================================================= -->
    <!-- SPRING BOOT                                                                             -->
    <!-- ======================================================================================= -->
    <!--SPRING BOOT STARTER WEB-->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!--SPRING BOOT STARTER ACTUATOR-->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    <dependency>
      <groupId>io.micrometer</groupId>
      <artifactId>micrometer-registry-prometheus</artifactId>
    </dependency>

    <!--SPRINGDOC OPENAPI UI-->
    <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-ui</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-security</artifactId>
    </dependency>

    <!--LOMBOK-->
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <scope>provided</scope>
    </dependency>

    <!-- ======================================================================================= -->
    <!-- ACTIVEMQ                                                                                -->
    <!-- ======================================================================================= -->

    <!--ACTIVEMQ CONNECTION POOLING-->
    <dependency>
      <groupId>org.apache.activemq</groupId>
      <artifactId>activemq-pool</artifactId>
    </dependency>
    <dependency>
      <groupId>org.messaginghub</groupId>
      <artifactId>pooled-jms</artifactId>
    </dependency>
<#if projectDescription.contextDescriptions?size gt 1>
  <#list projectDescription.contextDescriptions as contextDescription>

    <!-- ======================================================================================= -->
    <!-- ${ contextDescription.contextName } -->
    <!-- ======================================================================================= -->
    <!--API DETAIL-->
    <dependency>
      <groupId>${ contextDescription.groupId }</groupId>
      <artifactId>${ contextDescription.modulePrefix }api-detail</artifactId>
    </dependency>

    <!-- ======================================================================================= -->
    <!-- API CLIENTS                                                                             -->
    <!-- ======================================================================================= -->

    <#if contextDescription.enablement.apiClientBatchProcessActiveMqScaffolder>
    <!--BATCH PROCESS SUBSCRIBER ACTIVEMQ-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }api-clients</groupId>
      <artifactId>${ contextDescription.modulePrefix }api-client-batch-process-subscriber-activemq</artifactId>
    </dependency>

    </#if>
    <!--DOMAIN MESSAGE SUBSCRIBER ACTIVEMQ-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }api-clients</groupId>
      <artifactId>${ contextDescription.modulePrefix }api-client-domain-message-subscriber-activemq</artifactId>
    </dependency>

    <!--REST SPRING-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }api-clients</groupId>
      <artifactId>${ contextDescription.modulePrefix }api-client-rest-spring</artifactId>
    </dependency>

    <!-- ======================================================================================= -->
    <!-- DOMAIN DETAILS                                                                          -->
    <!-- ======================================================================================= -->

    <!--DOMAIN MESSAGE PUBLISHER ACTIVEMQ-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }domain-details</groupId>
      <artifactId>${ contextDescription.modulePrefix }domain-detail-domain-message-publisher-activemq</artifactId>
    </dependency>

    <#if contextDescription.enablement.domainDetailRepositoryInMemoryScaffolder>
    <!--DOMAIN REPOSITORY IN MEMORY-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }domain-details</groupId>
      <artifactId>${ contextDescription.modulePrefix }domain-detail-repository-inmemory</artifactId>
    </dependency>

    </#if>
    <!--DOMAIN REPOSITORY SPRING DATA JPA-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }domain-details</groupId>
      <artifactId>${ contextDescription.modulePrefix }domain-detail-repository-springdatajpa</artifactId>
    </dependency>

    <!--DOMAIN SERVICES-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }domain-details</groupId>
      <artifactId>${ contextDescription.modulePrefix }domain-detail-services</artifactId>
    </dependency>

    <!-- ======================================================================================= -->
    <!-- AUXILIARY DETAILS                                                                       -->
    <!-- ======================================================================================= -->

    <#if contextDescription.enablement.auxDetailAlertSlackScaffolder>
    <!--ALERT SLACK-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }aux-details</groupId>
      <artifactId>${ contextDescription.modulePrefix }aux-detail-alert-slack</artifactId>
    </dependency>

    </#if>
    <#if contextDescription.enablement.auxDetailPropertyFileScaffolder>
    <!--PROPERTY FILE-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }aux-details</groupId>
      <artifactId>${ contextDescription.modulePrefix }aux-detail-property-file</artifactId>
    </dependency>
    </#if>
  </#list>
<#else>

    <!--API DETAIL-->
    <dependency>
      <groupId>${ projectDescription.groupId }</groupId>
      <artifactId>${ projectDescription.modulePrefix }api-detail</artifactId>
    </dependency>

    <!-- ======================================================================================= -->
    <!-- API CLIENTS                                                                             -->
    <!-- ======================================================================================= -->

    <!--BATCH PROCESS SUBSCRIBER ACTIVEMQ-->
    <dependency>
      <groupId>${ projectDescription.groupId }.${ projectDescription.modulePrefix }api-clients</groupId>
      <artifactId>${ projectDescription.modulePrefix }api-client-batch-process-subscriber-activemq</artifactId>
    </dependency>

    <!--DOMAIN MESSAGE SUBSCRIBER ACTIVEMQ-->
    <dependency>
      <groupId>${ projectDescription.groupId }.${ projectDescription.modulePrefix }api-clients</groupId>
      <artifactId>${ projectDescription.modulePrefix }api-client-domain-message-subscriber-activemq</artifactId>
    </dependency>

    <!--REST SPRING-->
    <dependency>
      <groupId>${ projectDescription.groupId }.${ projectDescription.modulePrefix }api-clients</groupId>
      <artifactId>${ projectDescription.modulePrefix }api-client-rest-spring</artifactId>
    </dependency>

    <!-- ======================================================================================= -->
    <!-- DOMAIN DETAILS                                                                          -->
    <!-- ======================================================================================= -->

    <!--DOMAIN MESSAGE PUBLISHER ACTIVEMQ-->
    <dependency>
      <groupId>${ projectDescription.groupId }.${ projectDescription.modulePrefix }domain-details</groupId>
      <artifactId>${ projectDescription.modulePrefix }domain-detail-domain-message-publisher-activemq</artifactId>
    </dependency>

    <!--DOMAIN REPOSITORY SPRING DATA JPA-->
    <dependency>
      <groupId>${ projectDescription.groupId }.${ projectDescription.modulePrefix }domain-details</groupId>
      <artifactId>${ projectDescription.modulePrefix }domain-detail-repository-springdatajpa</artifactId>
    </dependency>

    <!--DOMAIN SERVICES-->
    <dependency>
      <groupId>${ projectDescription.groupId }.${ projectDescription.modulePrefix }domain-details</groupId>
      <artifactId>${ projectDescription.modulePrefix }domain-detail-services</artifactId>
    </dependency>

    <!-- ======================================================================================= -->
    <!-- AUXILIARY DETAILS                                                                       -->
    <!-- ======================================================================================= -->

    <!--ALERT SLACK-->
    <dependency>
      <groupId>${ projectDescription.groupId }.${ projectDescription.modulePrefix }aux-details</groupId>
      <artifactId>${ projectDescription.modulePrefix }aux-detail-alert-slack</artifactId>
    </dependency>

    <!--PROPERTY FILE-->
    <dependency>
      <groupId>${ projectDescription.groupId }.${ projectDescription.modulePrefix }aux-details</groupId>
      <artifactId>${ projectDescription.modulePrefix }aux-detail-property-file</artifactId>
    </dependency>

</#if>
  </dependencies>

  <!--BUILD-->
  <build>
    <finalName>${ projectDescription.modulePrefix }app</finalName>
    <#noparse>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <configuration>
          <fork>true</fork>
          <skip>false</skip>
        </configuration>
        <executions>
          <execution>
            <goals>
              <goal>repackage</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>

  <profiles>
    <!--OPENAPI-ALL-GENERATED-->
    <profile>
      <id>openapi-all-generated</id>
      <activation>
        <activeByDefault>false</activeByDefault>
      </activation>
      <build>
        <plugins>
          <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <executions>
              <execution>
                <id>pre-integration-test</id>
                <goals>
                  <goal>start</goal>
                </goals>
              </execution>
              <execution>
                <id>post-integration-test</id>
                <goals>
                  <goal>stop</goal>
                </goals>
              </execution>
            </executions>
          </plugin>
          <plugin>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-maven-plugin</artifactId>
            <version>${springdoc-openapi-maven-plugin.version}</version>
            <executions>
              <execution>
                <id>integration-test</id>
                <goals>
                  <goal>generate</goal>
                </goals>
              </execution>
            </executions>
            <configuration>
              <apiDocsUrl>http://localhost:8080/v3/api-docs.yaml</apiDocsUrl>
              <outputFileName>openapi.yaml</outputFileName>
              <outputDir>${project.basedir}/src/main/resources/openapi</outputDir>
            </configuration>
          </plugin>
        </plugins>
      </build>
    </profile>

    <!--OPENAPI-USER-GENERATED-->
    <profile>
      <id>openapi-user-generated</id>
      <activation>
        <activeByDefault>false</activeByDefault>
      </activation>
      <build>
        <plugins>
          <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <executions>
              <execution>
                <id>pre-integration-test</id>
                <goals>
                  <goal>start</goal>
                </goals>
              </execution>
              <execution>
                <id>post-integration-test</id>
                <goals>
                  <goal>stop</goal>
                </goals>
              </execution>
            </executions>
          </plugin>
          <plugin>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-maven-plugin</artifactId>
            <version>${springdoc-openapi-maven-plugin.version}</version>
            <executions>
              <execution>
                <id>integration-test</id>
                <goals>
                  <goal>generate</goal>
                </goals>
              </execution>
            </executions>
            <configuration>
              <apiDocsUrl>http://localhost:8080/v3/api-docs.yaml/openapi-user</apiDocsUrl>
              <outputFileName>openapi-user.yaml</outputFileName>
              <outputDir>${project.basedir}/src/main/resources/openapi</outputDir>
            </configuration>
          </plugin>
        </plugins>
      </build>
    </profile>

    <!--OPENAPI-ADMIN-GENERATED-->
    <profile>
      <id>openapi-admin-generated</id>
      <activation>
        <activeByDefault>false</activeByDefault>
      </activation>
      <build>
        <plugins>
          <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <executions>
              <execution>
                <id>pre-integration-test</id>
                <goals>
                  <goal>start</goal>
                </goals>
              </execution>
              <execution>
                <id>post-integration-test</id>
                <goals>
                  <goal>stop</goal>
                </goals>
              </execution>
            </executions>
          </plugin>
          <plugin>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-maven-plugin</artifactId>
            <version>${springdoc-openapi-maven-plugin.version}</version>
            <executions>
              <execution>
                <id>integration-test</id>
                <goals>
                  <goal>generate</goal>
                </goals>
              </execution>
            </executions>
            <configuration>
              <apiDocsUrl>http://localhost:8080/v3/api-docs.yaml/openapi-admin</apiDocsUrl>
              <outputFileName>openapi-admin.yaml</outputFileName>
              <outputDir>${project.basedir}/src/main/resources/openapi</outputDir>
            </configuration>
          </plugin>
        </plugins>
      </build>
    </profile>
  </profiles>
  </#noparse>
</project>
