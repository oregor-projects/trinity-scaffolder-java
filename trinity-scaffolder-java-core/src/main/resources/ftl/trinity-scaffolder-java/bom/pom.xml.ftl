<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xmlns="http://maven.apache.org/POM/4.0.0"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <parent>
    <groupId>${ contextDescription.groupId }</groupId>
    <artifactId>${ contextDescription.artifactId }</artifactId>
    <version>${ projectDescription.version }</version>
  </parent>
  <modelVersion>4.0.0</modelVersion>

  <groupId>${ contextDescription.groupId }</groupId>
  <artifactId>${ contextDescription.modulePrefix }bom</artifactId>

  <dependencies>
    <!--API DETAIL-->
    <dependency>
      <groupId>${ contextDescription.groupId }</groupId>
      <artifactId>${ contextDescription.modulePrefix }api-detail</artifactId>
    </dependency>

    <!-- ======================================================================================= -->
    <!-- API CLIENTS                                                                             -->
    <!-- ======================================================================================= -->

    <!--BATCH PROCESS SUBSCRIBER-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }api-clients</groupId>
      <artifactId>${ contextDescription.modulePrefix }api-client-batch-process-subscriber</artifactId>
    </dependency>

    <!--BATCH PROCESS SUBSCRIBER ACTIVEMQ-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }api-clients</groupId>
      <artifactId>${ contextDescription.modulePrefix }api-client-batch-process-subscriber-activemq</artifactId>
    </dependency>

    <!--DOMAIN MESSAGE SUBSCRIBER-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }api-clients</groupId>
      <artifactId>${ contextDescription.modulePrefix }api-client-domain-message-subscriber</artifactId>
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

    <!--ALERT SLACK-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }aux-details</groupId>
      <artifactId>${ contextDescription.modulePrefix }aux-detail-alert-slack</artifactId>
    </dependency>

    <!--PROPERTY FILE-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }aux-details</groupId>
      <artifactId>${ contextDescription.modulePrefix }aux-detail-property-file</artifactId>
    </dependency>

  </dependencies>

</project>
