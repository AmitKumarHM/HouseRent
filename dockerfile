FROM openjdk:8
COPY demo.jar .
EXPOSE 8080
CMD java -jar ./demo.jar