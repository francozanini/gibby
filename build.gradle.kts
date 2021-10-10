
plugins {
    java

    //Spring plugin
    id("org.springframework.boot") version ("2.5.4")
    id("io.spring.dependency-management").version("1.0.3.RELEASE")

}


repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.spring.io/milestone")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.22")
    annotationProcessor("org.projectlombok:lombok:1.18.22")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.discord4j:discord4j-core:3.2.0")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("org.springframework.boot:spring-boot-starter-web:2.5.4")
}
