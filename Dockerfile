FROM openjdk:15-alpine

COPY /home/runner/work/diplo/diplom/build/libs/diplom-0.0.1-SNAPSHOT.jar /opt/diplom.jar

ENTRYPOINT java -Xmx2G -jar /opt/diplom.jar
