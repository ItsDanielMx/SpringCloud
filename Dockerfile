FROM maven:3.9-eclipse-temurin-21 AS build

# Copy local code to the container image.
COPY . /home/maven/src
WORKDIR /home/maven/src

# Build a release artifact.
RUN mvn clean package -DskipTests

# Use multi-stage build with a slim JRE image
FROM eclipse-temurin:21-jre-alpine

RUN mkdir /app

# Copy the jar to the production image from the builder stage.
COPY --from=build /home/maven/src/target/*.jar /app/app.jar

# Run the web service on container startup.
ENTRYPOINT ["java","-jar","/app/app.jar"]