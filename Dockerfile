FROM openjdk:15-alpine

COPY ./diplom-0.0.1-SNAPSHOT.jar /opt/diplom.jar

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://ec2-54-195-141-170.eu-west-1.compute.amazonaws.com:5432/da5ejtdhcst9m?password=24a82344b0ac7ad9236725a9c1c5ed22e98245a8d8e32d8a07cb211779ab1c91&sslmode=require&user=gmzmmobpoqbher
ENV PORT 5000

EXPOSE $PORT

CMD java -Dserver.port=${PORT} -Xmx2G -jar /opt/diplom.jar
