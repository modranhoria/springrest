FROM maven as build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
FROM openjdk:17-jdk
COPY --from=build /home/app/target/springrest-layered-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 7000
ENTRYPOINT ["java", "-jar", "/app.jar"]




