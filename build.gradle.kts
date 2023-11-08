plugins {
	java
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
}

group = "com.ESDC"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf") {
		exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
	}
	implementation("org.springframework.boot:spring-boot-starter-web") {
		exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
	}
	implementation("org.springframework.boot:spring-boot-starter-mustache") {
		exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
	}
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation( "com.google.firebase:firebase-admin:9.2.0")
	implementation ("org.springframework.boot:spring-boot-starter-security")

	implementation ("org.thymeleaf.extras:thymeleaf-extras-springsecurity6:3.1.1.RELEASE")
	implementation ("org.springframework.security:spring-security-test")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
