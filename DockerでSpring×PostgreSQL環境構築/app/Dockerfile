FROM maven:3.6.3-jdk-11 AS builder
WORKDIR /tmp
COPY ./tmpSpringBoot/src ./src
COPY ./tmpSpringBoot/pom.xml .
RUN mvn package
FROM openjdk:11.0-jdk
COPY --from=builder /tmp/target/tmpSpringBoot-1.0.jar /app/tmpSpringBoot-1.0.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/tmpSpringBoot-1.0.jar"]