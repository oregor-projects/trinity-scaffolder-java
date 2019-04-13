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
  <artifactId>${ projectDescription.modulePrefix }-app</artifactId>

  <dependencies>
    <!-- ======================================================================================= -->
    <!-- SPRING BOOT                                                                             -->
    <!-- ======================================================================================= -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>

    <!--API DETAIL-->
    <dependency>
      <groupId>${ projectDescription.groupId }</groupId>
      <artifactId>${ projectDescription.modulePrefix }-api-detail</artifactId>
    </dependency>

    <!-- ======================================================================================= -->
    <!-- API CLIENTS                                                                             -->
    <!-- ======================================================================================= -->

    <!-- REST SPRING -->
    <dependency>
      <groupId>${ projectDescription.groupId }.${ projectDescription.modulePrefix }-api-clients</groupId>
      <artifactId>${ projectDescription.modulePrefix }-api-rest</artifactId>
    </dependency>

    <!-- SUBSCRIBER ACTIVEMQ -->
    <dependency>
      <groupId>${ projectDescription.groupId }.${ projectDescription.modulePrefix }-api-clients</groupId>
      <artifactId>${ projectDescription.modulePrefix }-api-subscriber-activemq</artifactId>
    </dependency>

    <!-- ======================================================================================= -->
    <!-- DOMAIN DETAILS                                                                          -->
    <!-- ======================================================================================= -->

    <!-- PERSISTENCE RDBMS -->
    <dependency>
      <groupId>${ projectDescription.groupId }.${ projectDescription.modulePrefix }-domain-details</groupId>
      <artifactId>${ projectDescription.modulePrefix }-domain-persistence-rdbms</artifactId>
    </dependency>

    <!-- ======================================================================================= -->
    <!-- AUXILIARY DETAILS                                                                       -->
    <!-- ======================================================================================= -->

    <!-- PUBLISHER ACTIVEMQ -->
    <dependency>
      <groupId>${ projectDescription.groupId }.${ projectDescription.modulePrefix }-aux-details</groupId>
      <artifactId>${ projectDescription.modulePrefix }-publisher-activemq</artifactId>
    </dependency>

    <!-- ======================================================================================= -->
    <!-- DATABASE -->
    <!-- ======================================================================================= -->
    <dependency>
      <groupId>com.h2database</groupId>
      <artifactId>h2</artifactId>
      <scope>runtime</scope>
    </dependency>

    <!-- ======================================================================================= -->
    <!-- TEST -->
    <!-- ======================================================================================= -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
    </plugins>
  </build>

</project>
