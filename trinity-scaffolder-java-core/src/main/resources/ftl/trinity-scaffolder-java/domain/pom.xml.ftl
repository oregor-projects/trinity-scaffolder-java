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
  <artifactId>${ projectDescription.modulePrefix }-domain</artifactId>

  <dependencies>
    <!--JPA ANNOTATIONS-->
    <dependency>
      <groupId>javax.persistence</groupId>
      <artifactId>javax.persistence-api</artifactId>
    </dependency>

    <!--QUERY DSL-->
    <dependency>
      <groupId>com.querydsl</groupId>
      <artifactId>querydsl-apt</artifactId>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>com.querydsl</groupId>
      <artifactId>querydsl-jpa</artifactId>
    </dependency>

    <!--DDD4J-->
    <dependency>
      <groupId>com.oregor.ddd4j</groupId>
      <artifactId>ddd4j-domain</artifactId>
    </dependency>

    <!--TEST-->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>
