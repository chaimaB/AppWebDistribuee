FROM openjdk
EXPOSE 8690
ADD /target/service-project-0.0.1-SNAPSHOT.jar docker-service-project.jar
ENTRYPOINT ["java","-jar","docker-service-project.jar"]