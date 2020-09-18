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
  <artifactId>${ contextDescription.modulePrefix }api-client-rest-spring</artifactId>

  <dependencies>
    <!--SPRING BOOT WEB-->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!--SPRING BOOT STARTER SECURITY-->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

    <!--SPRING BOOT STARTER AOP-->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-aop</artifactId>
    </dependency>

    <!--SPRING BOOT STARTER ACTUATOR-->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>

    <!--APACHE-->
    <dependency>
      <groupId>org.apache.commons</groupId>
      <artifactId>commons-lang3</artifactId>
    </dependency>
    <dependency>
      <groupId>commons-io</groupId>
      <artifactId>commons-io</artifactId>
    </dependency>

    <!--SWAGGER-UI-->
    <dependency>
      <groupId>org.webjars</groupId>
      <artifactId>swagger-ui</artifactId>
    </dependency>

    <!--TRINITY4J-->
    <dependency>
      <groupId>com.oregor.trinity4j</groupId>
      <artifactId>trinity4j-commons</artifactId>
    </dependency>
    <dependency>
      <groupId>com.oregor.trinity4j.trinity4j-api-clients</groupId>
      <artifactId>trinity4j-api-client-rest-spring</artifactId>
    </dependency>

    <!--API-->
    <dependency>
      <groupId>${ contextDescription.groupId }</groupId>
      <artifactId>${ contextDescription.modulePrefix }api</artifactId>
    </dependency>

    <!--TEST-->
    <dependency>
      <groupId>com.atlassian.oai</groupId>
      <artifactId>swagger-request-validator-mockmvc</artifactId>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>
