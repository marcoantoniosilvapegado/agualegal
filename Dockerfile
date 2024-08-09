FROM maven:3.8.3-openjdk-17 AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -f pom.xml clean package -DskipTests=True

FROM registry.access.redhat.com/ubi8/openjdk-17
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 8080