FROM gradle:jdk17 as builder

WORKDIR /app

COPY . .

RUN gradle bootJar

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

ENV SPRING_PROFILES_ACTIVE dev

ENV DATABASE_USERNAME postgres

ENV DATABASE_PASSWORD jrmjFwJojvYHqdRU

ENV DATABASE_URL jdbc:postgresql://db.faealilgdzehkthqhxwf.supabase.co:5432/postgres?user=postgres&password=jrmjFwJojvYHqdRU

COPY --from=builder /app/build/libs/*.jar ./disk-accounting.jar

CMD ["java", "-jar", "disk-accounting.jar"]