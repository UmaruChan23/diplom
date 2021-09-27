FROM openjdk:15-alpine

WORKDIR /opt

COPY /*.jar /opt/diplom.jar

RUN ls -lah ../

ENTRYPOINT java -Xmx2G -jar /opt/diplom.jar
