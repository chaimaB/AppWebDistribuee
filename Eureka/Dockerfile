FROM openjdk
EXPOSE 8761
ADD /target/Eureka-0.0.1-SNAPSHOT.jar docker-eureka.jar
ENTRYPOINT ["java","-jar","docker-eureka.jar"]