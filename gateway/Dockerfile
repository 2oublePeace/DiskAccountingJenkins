FROM gradle:jdk17 as builder

WORKDIR /app

COPY . .

RUN gradle :gateway:bootJar

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=builder /app/gateway/build/libs/*.jar ./gateway.jar

CMD ["java", "-jar", "gateway.jar"]