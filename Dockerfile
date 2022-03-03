FROM adoptopenjdk/openjdk11:ubi

COPY /target/record-store-0.0.1-SNAPSHOT.jar record-store-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/record-store-0.0.1-SNAPSHOT.jar"]

