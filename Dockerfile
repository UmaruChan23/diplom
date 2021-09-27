FROM openjdk:15-alpine

COPY /*.jar /opt/diplom.jar

RUN ls -lah /home/runner/work/diplom/*

ENTRYPOINT java -Xmx2G -jar /opt/diplom.jar
