plugins {
	kotlin("plugin.jpa") version "1.8.22"
}

dependencies {
	implementation(project(":main-service"))
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	runtimeOnly("org.postgresql:postgresql")
}
