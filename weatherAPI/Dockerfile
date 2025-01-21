FROM openjdk:8
EXPOSE 8080
ADD target/weather-api.jar  weather-api.jar
ENTRYPOINT ["java","-jar", "/weather-api.jar"]