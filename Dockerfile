FROM java:8
EXPOSE 8080
ADD /build/libs/spring-docker-gradle-0.0.1-SNAPSHOT.jar spring-docker-gradle-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","spring-docker-gradle-0.0.1-SNAPSHOT.jar"]