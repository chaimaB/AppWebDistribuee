# AppWebDistribuee
Projet application web distribuée.

SPRING BOOT MICROCSERVICE USING SPRING BOOT, NODEJS, EUREKA, ZUUL, DOCKER
This project is created to get experience on Microservices. This is a simple project for projects managment.

**There are four microservices:**
- *HR* : This microservice is responsible for managing employes and developped in spring boot.
- *Equipment* : This microservice is responsible for managing equipments and developped in spring boot.
- *Project* : This microservice is responsible for managing projects and developped in spring boot.
- *Client* : This microservice is responsible for managing clients and developped in spring boot.
- *Authentification* : This microservice is responsible for the authentification and developped in nodeJs.

### Gateways ###
 **Service	EndPoint**
- HR	/hr-service/
- Equipment	/matereiels-service/
- Project	/project-service/
- Client	/client-service/
- Authentification	/node-service/
- URI for gateway : http://localhost:8762

### Build & Run ###

In repository /build/docker run :

- *>sudo ./deploy.sh* : build docker images and containers and run containers
- *>sudo ./clean.sh* : stop the dockerized services

**Each maven module has a Dockerfile.**

## In docker-compose.yml file:

 - *HR Service : 8880 port is mapped to 7500 port of host
 - *Equipment Service : 8700 port is mapped to 7501 port of host
 - *Project Service : 8090 port is mapped to 7502 port of host
 - *Client Service : 8085 port is mapped to 7503 port of host
 - *Authentification Service : 3000 port is mapped to 3000 port of host
 - *Eureka Discovery Service : 8761 port is mapped to 8761 port of host
 - *Zuul Gateway Service : 8762 port is mapped to 8762 port of host
