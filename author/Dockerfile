#GENERAR LA IMAGEN
# docker build -t author .
# docker tag author axeleofc/author --> en caso no se quiera generar la imagen desde 0
# docker build -t axeleofc/author .


# docker login
# docker push axeleofc/author

FROM eclipse-temurin:17.0.11_9-jre-jammy

RUN mkdir /app
WORKDIR /app

COPY build/quarkus-app/app ./app
COPY build/quarkus-app/lib/ ./lib
COPY build/quarkus-app/quarkus/ ./quarkus
COPY build/quarkus-app/quarkus-run.jar app.jar

CMD ["java","-jar","app.jar"]