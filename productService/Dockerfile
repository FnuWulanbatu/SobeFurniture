FROM openjdk:17
EXPOSE 8080
ADD target/spring-boot-app.jar product-service-app.jar
ENTRYPOINT ["java","-jar","/product-service-app.jar"]