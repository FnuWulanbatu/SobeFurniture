FROM openjdk:17
EXPOSE 8081
ADD target/spring-boot-app.jar cart-service-app.jar
ENTRYPOINT ["java","-jar","/cart-service-app.jar"]