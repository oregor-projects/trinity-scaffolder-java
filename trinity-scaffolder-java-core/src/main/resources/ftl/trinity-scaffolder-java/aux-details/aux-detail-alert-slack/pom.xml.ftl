<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xmlns="http://maven.apache.org/POM/4.0.0"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <parent>
    <groupId>${ contextDescription.groupId }</groupId>
    <artifactId>${ contextDescription.modulePrefix }aux-details</artifactId>
    <version>${ projectDescription.version }</version>
  </parent>
  <modelVersion>4.0.0</modelVersion>

  <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }aux-details</groupId>
  <artifactId>${ contextDescription.modulePrefix }aux-detail-alert-slack</artifactId>

  <dependencies>
    <!--SPRING CONTEXT-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
    </dependency>

    <!--TRINITY4J-->
    <dependency>
      <groupId>com.oregor.trinity4j.trinity4j-aux-details</groupId>
      <artifactId>trinity4j-aux-detail-alert-slack</artifactId>
    </dependency>

    <!--AUX-->
    <dependency>
      <groupId>${ contextDescription.groupId }</groupId>
      <artifactId>${ contextDescription.modulePrefix }aux</artifactId>
    </dependency>
  </dependencies>

</project>
