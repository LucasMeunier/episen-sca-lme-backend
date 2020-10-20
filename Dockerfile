# For Java 13 alpine version
FROM openjdk:13-jdk-alpine
# Add label
LABEL description="Lucas API"
LABEL version="3.0"
# Add user and group
#RUN addgroup -S spring && adduser -S spring -G spring
# Select user
#USER spring:spring

# Refer to Maven build -> finalName
ARG JAR_FILE=target/episen-sca-lme-backend-0.0.1-SNAPSHOT.jar

RUN mkdir -p /app

# cd /app
WORKDIR /app

RUN chmod +x /app

# cp target/episen-sca-lme-backend-0.0.1-SNAPSHOT/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
