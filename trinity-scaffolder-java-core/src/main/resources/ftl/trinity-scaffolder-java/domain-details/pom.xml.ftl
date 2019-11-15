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
  <artifactId>${ contextDescription.modulePrefix }domain-details</artifactId>
  <packaging>pom</packaging>

  <modules>
    <module>${ contextDescription.modulePrefix }domain-detail-domain-message-publisher-activemq</module>
    <module>${ contextDescription.modulePrefix }domain-detail-repository-inmemory</module>
    <module>${ contextDescription.modulePrefix }domain-detail-repository-springdatajpa</module>
    <module>${ contextDescription.modulePrefix }domain-detail-services</module>
  </modules>

</project>
