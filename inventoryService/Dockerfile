FROM openjdk:17
EXPOSE 8081
ADD target/inventoryService.jar inventoryService.jar
ENTRYPOINT ["java","-jar","/inventoryService.jar"]