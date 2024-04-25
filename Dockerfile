FROM openjdk:17
ADD target/post_service.jar app.jar
ENTRYPOINT ["java", "-jar","app.jar"]


