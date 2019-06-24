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

    <!--PERIODIC PROCESS-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }api-clients</groupId>
      <artifactId>${ contextDescription.modulePrefix }api-client-periodic-process</artifactId>
    </dependency>

    <!--PERIODIC PROCESS TRIGGER ACTIVEMQ-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }api-clients</groupId>
      <artifactId>${ contextDescription.modulePrefix }api-client-periodic-process-trigger-activemq</artifactId>
    </dependency>

    <!--REST SPRING-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }api-clients</groupId>
      <artifactId>${ contextDescription.modulePrefix }api-client-rest-spring</artifactId>
    </dependency>

    <!--SCHEDULER CAMEL-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }api-clients</groupId>
      <artifactId>${ contextDescription.modulePrefix }api-client-scheduler-camel</artifactId>
    </dependency>

    <!--SUBSCRIBER-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }api-clients</groupId>
      <artifactId>${ contextDescription.modulePrefix }api-client-subscriber</artifactId>
    </dependency>

    <!--SUBSCRIBER ACTIVEMQ-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }api-clients</groupId>
      <artifactId>${ contextDescription.modulePrefix }api-client-subscriber-activemq</artifactId>
    </dependency>

    <!-- ======================================================================================= -->
    <!-- DOMAIN DETAILS                                                                          -->
    <!-- ======================================================================================= -->

    <!--REPOSITORY SPRING DATA JPA-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }domain-details</groupId>
      <artifactId>${ contextDescription.modulePrefix }domain-detail-repository-springdatajpa</artifactId>
    </dependency>

    <!--SCHEDULED PUBLISHER CAMEL ACTIVEMQ-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }domain-details</groupId>
      <artifactId>${ contextDescription.modulePrefix }domain-detail-scheduled-publisher-camel-activemq</artifactId>
    </dependency>

    <!--DOMAIN SERVICES-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }domain-details</groupId>
      <artifactId>${ contextDescription.modulePrefix }domain-detail-services</artifactId>
    </dependency>

    <!-- ======================================================================================= -->
    <!-- AUXILIARY DETAILS                                                                       -->
    <!-- ======================================================================================= -->

    <!--PUBLISHER ACTIVEMQ-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }aux-details</groupId>
      <artifactId>${ contextDescription.modulePrefix }aux-detail-publisher-activemq</artifactId>
    </dependency>
  </dependencies>

</project>
