FROM ubuntu:latest AS build

RUN apt-get update
RUN amazoncorretto:21 java -version

COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM amazoncorretto:21

EXPOSE 8080

COPY --from=build /target/estoque-de-equipamentos-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]