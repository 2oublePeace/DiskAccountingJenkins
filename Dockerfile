FROM gradle:jdk17 as builder

WORKDIR /app

COPY build.gradle.kts settings.gradle.kts /app/

COPY src /app/src/

RUN gradle clean build

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

ENV SPRING_PROFILES_ACTIVE dev

ENV DATABASE_USERNAME postgres

ENV DATABASE_PASSWORD jrmjFwJojvYHqdRU

ENV DATABASE_URL jdbc:postgresql://db.faealilgdzehkthqhxwf.supabase.co:5432/postgres?user=postgres&password=jrmjFwJojvYHqdRU

COPY --from=builder /app/build/libs/DiskAccounting-0.0.1-SNAPSHOT.jar /app/

CMD ["java", "-jar", "/app/DiskAccounting-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080