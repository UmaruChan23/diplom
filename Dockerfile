FROM openjdk:15-alpine

WORKDIR /opt

COPY ./build/libs/diplom-0.0.1-SNAPSHOT.jar /opt/diplom.jar

ENTRYPOINT java -Xmx2G -jar /opt/diplom.jar