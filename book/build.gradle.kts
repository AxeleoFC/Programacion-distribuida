plugins {
    id("java")
    id("io.quarkus") version "3.11.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}


val quarkusVersion = "3.11.1"
dependencies {
    //Evita poner la version en las siguientes dependencias
    implementation(enforcedPlatform("io.quarkus.platform:quarkus-bom:${quarkusVersion}"))
    implementation("io.quarkus:quarkus-arc") //Implementacion de CDI de quarkus (Motor de comp de negocio)
    implementation("io.quarkus:quarkus-resteasy-reactive") //Motor de rest JAXRS en su forma reactiva
    implementation("io.quarkus:quarkus-resteasy-reactive-jackson") //JSON
    implementation("io.quarkus:quarkus-hibernate-orm-panache") //JPA Hibernate+ repo
    //implementation("com.h2database:h2:2.2.224")
    // implementation("org.xerial:sqlite-jdbc:3.46.0.0")
    implementation("org.postgresql:postgresql:42.7.3")
    implementation("io.quarkus:quarkus-jdbc-postgresql:3.11.2")

    implementation("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")

    //REST CLIENT
    implementation("io.quarkus:quarkus-rest-client-reactive")
    implementation("io.quarkus:quarkus-rest-client-reactive-jackson")
    //Load Balancer
    // implementation("io.smallrye.stork:stork-service-discovery-static-list:2.6.0")
    implementation("io.smallrye.stork:stork-service-discovery-consul:2.6.0")
    implementation("io.smallrye.reactive:smallrye-mutiny-vertx-consul-client")


    implementation("io.quarkus:quarkus-smallrye-health")

}