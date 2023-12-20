FROM openjdk:17-jdk-slim

COPY build/libs/DiskAccounting-0.0.1-SNAPSHOT.jar /DiskAccounting.jar

ENV SPRING_PROFILES_ACTIVE dev

ENV DATABASE_USERNAME postgres

ENV DATABASE_PASSWORD jrmjFwJojvYHqdRU

ENV DATABASE_URL jdbc:postgresql://db.faealilgdzehkthqhxwf.supabase.co:5432/postgres?user=postgres&password=jrmjFwJojvYHqdRU

CMD ["java", "-jar", "/DiskAccounting.jar"]

EXPOSE 8080