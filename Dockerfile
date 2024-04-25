FROM openjdk:17
ADD target/post_service_new.jar app.jar
ENTRYPOINT ["java", "-jar","app.jar"]


