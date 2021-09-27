FROM openjdk:15-alpine

WORKDIR /opt

COPY /*.jar /opt/diplom.jar

RUN ls /

ENTRYPOINT java -Xmx2G -jar /opt/diplom.jar
