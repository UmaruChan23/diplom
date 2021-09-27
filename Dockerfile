FROM openjdk:15-alpine

COPY ./diplom-0.0.1-SNAPSHOT.jar /opt/diplom.jar

CMD java -Xmx2G -jar /opt/diplom.jar
