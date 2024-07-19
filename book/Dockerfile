#GENERAR LA IMAGEN
# docker build -t book .
# docker tag book axeleofc/book --> en caso no se quiera generar la imagen desde 0
# docker build -t axeleofc/book .

# docker login
# docker push axeleofc/book

FROM eclipse-temurin:17.0.11_9-jre-jammy
#FROM bellsoft/liberica-runtime-container:jdk-17-glibc

RUN mkdir /app
WORKDIR /app

COPY build/quarkus-app/app ./app
COPY build/quarkus-app/lib/ ./lib
COPY build/quarkus-app/quarkus/ ./quarkus
COPY build/quarkus-app/quarkus-run.jar app.jar

CMD ["java","-jar","app.jar"]