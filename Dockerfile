FROM openjdk:17-jdk-slim

COPY build/libs/DiskAccounting-0.0.1-SNAPSHOT.jar /DiskAccounting.jar

CMD ["java", "-jar", "/DiskAccounting.jar"]