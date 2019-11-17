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
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>

    <!--ACTIVEMQ CONNECTION POOLING-->
    <dependency>
      <groupId>org.apache.activemq</groupId>
      <artifactId>activemq-pool</artifactId>
    </dependency>
    <dependency>
      <groupId>org.messaginghub</groupId>
      <artifactId>pooled-jms</artifactId>
    </dependency>

    <!--METRICS-->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    <dependency>
      <groupId>io.micrometer</groupId>
      <artifactId>micrometer-registry-prometheus</artifactId>
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

    <!--BATCH PROCESS SUBSCRIBER ACTIVEMQ-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }api-clients</groupId>
      <artifactId>${ contextDescription.modulePrefix }api-client-batch-process-subscriber-activemq</artifactId>
    </dependency>

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

    <!--DOMAIN REPOSITORY IN MEMORY-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }domain-details</groupId>
      <artifactId>${ contextDescription.modulePrefix }domain-detail-repository-inmemory</artifactId>
    </dependency>

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
</#if>

    <!-- ======================================================================================= -->
    <!-- DATABASE -->
    <!-- ======================================================================================= -->
    <dependency>
      <groupId>com.h2database</groupId>
      <artifactId>h2</artifactId>
      <scope>runtime</scope>
    </dependency>

    <!-- ======================================================================================= -->
    <!-- TEST -->
    <!-- ======================================================================================= -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-api</artifactId>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <build>
    <finalName>${ projectDescription.modulePrefix }app</finalName>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
    </plugins>
  </build>

</project>
