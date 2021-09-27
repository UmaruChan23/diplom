FROM openjdk:15-alpine

WORKDIR /opt

COPY /home/runner/work/diplom/diplom/build/libs/*.jar /opt/diplom.jar

RUN ls -lah /home/runner/work/diplom/diplom/
RUN ls -lah /
RUN ls -lah /home/runner/work/diplom/
RUN ls -lah /build/libs/


ENTRYPOINT java -Xmx2G -jar /opt/diplom.jar
