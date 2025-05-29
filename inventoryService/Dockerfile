FROM openjdk:17
EXPOSE 8081
ADD target/spring-boot-app.jar inventory-service-app.jar
ENTRYPOINT ["java","-jar","/inventory-service-app.jar"]