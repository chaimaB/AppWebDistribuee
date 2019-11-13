FROM openjdk:8-jre-alpine
EXPOSE 8761
ADD /target/Eureka-0.0.1-SNAPSHOT.jar docker-eureka.jar
RUN /bin/sh -c 'touch /Eureka-0.0.1-SNAPSHOT.jar docker-eureka.jar'
ENTRYPOINT ["java","-jar","docker-eureka.jar"]