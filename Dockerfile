FROM openjdk:17
ADD target/post_service_new.jar post_service_new.jar
ENTRYPOINT ["java", "-jar","post_service_new.jar"]


