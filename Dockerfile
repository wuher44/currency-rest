FROM openjdk:8
ADD target/currency-rest-0.0.1-SNAPSHOT.jar .
EXPOSE 10011
CMD java -jar currency-rest-0.0.1-SNAPSHOT.jar

