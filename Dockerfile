FROM openjdk:15-alpine

WORKDIR /opt

COPY /home/runner/work/diplom/diplom/*.jar /opt/diplom.jar

ENTRYPOINT java -Xmx2G -jar /opt/diplom.jar