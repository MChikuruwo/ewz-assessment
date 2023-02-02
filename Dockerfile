FROM openjdk:17-slim-buster as builder

MAINTAINER EWZ

ADD target/assessment-0.0.1-SNAPSHOT.jar /opt/assessment-0.0.1-SNAPSHOT.jar

WORKDIR /opt

ENTRYPOINT ["java", "-jar", "assessment-0.0.1-SNAPSHOT.jar", "&"]