<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <parent>
    <artifactId>${ projectDescription.artifactId }</artifactId>
    <groupId>${ projectDescription.groupId }</groupId>
    <version>${ projectDescription.version }</version>
  </parent>
  <modelVersion>4.0.0</modelVersion>

  <groupId>${ contextDescription.groupId }</groupId>
  <artifactId>${ contextDescription.artifactId }</artifactId>
  <packaging>pom</packaging>

  <modules>
    <module>${ contextDescription.modulePrefix }api</module>
    <module>${ contextDescription.modulePrefix }api-clients</module>
    <module>${ contextDescription.modulePrefix }api-detail</module>
    <module>${ contextDescription.modulePrefix }aux</module>
    <module>${ contextDescription.modulePrefix }aux-details</module>
    <module>${ contextDescription.modulePrefix }bom</module>
    <module>${ contextDescription.modulePrefix }domain</module>
    <module>${ contextDescription.modulePrefix }domain-details</module>
  </modules>

</project>
