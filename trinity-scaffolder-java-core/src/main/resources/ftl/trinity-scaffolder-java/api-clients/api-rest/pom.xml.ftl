<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <parent>
    <groupId>${ projectDescription.groupId }</groupId>
    <artifactId>${ projectDescription.modulePrefix }-api-clients</artifactId>
    <version>${ projectDescription.version }</version>
  </parent>
  <modelVersion>4.0.0</modelVersion>

  <groupId>${ projectDescription.groupId }.${ projectDescription.modulePrefix }-api-clients</groupId>
  <artifactId>${ projectDescription.modulePrefix }-api-rest</artifactId>

  <dependencies>
    <!--SPRING BOOT WEB-->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!--SPRING SECURITY OAUTH2-->
    <#--<dependency>-->
    <#--<groupId>org.springframework.security.oauth.boot</groupId>-->
    <#--<artifactId>spring-security-oauth2-autoconfigure</artifactId>-->
    <#--<#noparse>-->
    <#--<version>${spring-security-oauth2-autoconfigure.version}</version>-->
    <#--</#noparse>-->
    <#--</dependency>-->

    <!--APACHE-->
    <dependency>
      <groupId>org.apache.commons</groupId>
      <artifactId>commons-lang3</artifactId>
    </dependency>
    <dependency>
      <groupId>commons-io</groupId>
      <artifactId>commons-io</artifactId>
    </dependency>

    <!--API-->
    <dependency>
      <groupId>${ projectDescription.groupId }</groupId>
      <artifactId>${ projectDescription.modulePrefix }-api</artifactId>
    </dependency>

    <!--OREGOR-DDD4J-->
    <dependency>
      <groupId>com.oregor.ddd4j</groupId>
      <artifactId>ddd4j-primary-adapter-rest-spring</artifactId>
    </dependency>
    <dependency>
      <groupId>com.oregor.ddd4j</groupId>
      <artifactId>ddd4j-core</artifactId>
    </dependency>

    <!--TEST-->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>
