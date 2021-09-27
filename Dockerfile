FROM openjdk:15-alpine

COPY /*.jar /opt/diplom.jar

ENTRYPOINT java -Xmx2G -jar /opt/diplom.jar
