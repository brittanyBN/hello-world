FROM openjdk:17
WORKDIR /
ADD build/libs/restJakarta-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080 5005
CMD java -jar app.jar