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
  <artifactId>${ contextDescription.modulePrefix }api-clients</artifactId>
  <packaging>pom</packaging>

  <modules>
    <#if contextDescription.enablement.apiClientBatchProcessScaffolder>
    <module>${ contextDescription.modulePrefix }api-client-batch-process-subscriber</module>
    </#if>
    <#if contextDescription.enablement.apiClientBatchProcessActiveMqScaffolder>
    <module>${ contextDescription.modulePrefix }api-client-batch-process-subscriber-activemq</module>
    </#if>
    <module>${ contextDescription.modulePrefix }api-client-domain-message-subscriber</module>
    <module>${ contextDescription.modulePrefix }api-client-domain-message-subscriber-activemq</module>
    <module>${ contextDescription.modulePrefix }api-client-rest-spring</module>
  </modules>

</project>
