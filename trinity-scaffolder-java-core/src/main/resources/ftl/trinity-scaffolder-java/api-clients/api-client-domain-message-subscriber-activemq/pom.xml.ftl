<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <parent>
    <groupId>${ contextDescription.groupId }</groupId>
    <artifactId>${ contextDescription.modulePrefix }api-clients</artifactId>
    <version>${ projectDescription.version }</version>
  </parent>
  <modelVersion>4.0.0</modelVersion>

  <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }api-clients</groupId>
  <artifactId>${ contextDescription.modulePrefix }api-client-domain-message-subscriber-activemq</artifactId>

  <dependencies>
    <!-- SPRING BOOT ACTIVEMQ -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-activemq</artifactId>
    </dependency>

    <!-- SPRING BOOT CAMEL -->
    <dependency>
      <groupId>org.apache.camel</groupId>
      <artifactId>camel-spring-boot-starter</artifactId>
    </dependency>

    <!-- ACTIVEMQ -->
    <dependency>
      <groupId>org.apache.activemq</groupId>
      <artifactId>activemq-camel</artifactId>
    </dependency>

    <!-- ACTIVEMQ POOLING -->
    <dependency>
      <groupId>org.messaginghub</groupId>
      <artifactId>pooled-jms</artifactId>
    </dependency>

    <!--API CLIENT DOMAIN MESSAGE-->
    <dependency>
      <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }api-clients</groupId>
      <artifactId>${ contextDescription.modulePrefix }api-client-domain-message-subscriber</artifactId>
    </dependency>

    <!--TEST-->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>