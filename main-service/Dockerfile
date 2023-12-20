FROM gradle:jdk17 as builder

WORKDIR /app

COPY . .

RUN gradle :main-service:bootJar

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=builder /app/main-service/build/libs/*.jar ./main-service.jar

CMD ["java", "-jar", "main-service.jar"]