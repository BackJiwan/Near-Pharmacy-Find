plugins {
    java
    groovy
    id("org.springframework.boot") version "2.6.7"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    this.archiveFileName.set("app.jar")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // redis
    implementation ("org.springframework.boot:spring-boot-starter-data-redis")

    // https://github.com/seruco/base62
    implementation ("io.seruco.encoding:base62:0.1.3")

    // spock
    testImplementation("org.spockframework:spock-core:2.1-groovy-3.0")
    testImplementation("org.spockframework:spock-spring:2.1-groovy-3.0")

    // 런타임에 클래스 기반 spock mock을 만들기 위해서 필요
    testImplementation("net.bytebuddy:byte-buddy:1.12.10")

    //testcontainers
    testImplementation("org.testcontainers:spock:1.17.1")
    testImplementation ("org.testcontainers:mariadb:1.18.3")

    // spring retry
    implementation("org.springframework.retry:spring-retry")

    // mockWebServer
    testImplementation("com.squareup.okhttp3:okhttp:4.10.0")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.10.0")

    // handlebars
    implementation ("pl.allegro.tech.boot:handlebars-spring-boot-starter:0.3.4")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// $ ./gradlew clean build -PKAKAO_REST_API_KEY={api key 값} 명령어로 전체 테스트 및 빌드하여 jar 파일 생성
tasks.processTestResources {
    val hasProperty = project.hasProperty("KAKAO_REST_API_KEY")
    println("Set kakao rest api key: $hasProperty")
    filesMatching("**/application.yml") {
        expand(project.properties)
    }
}
