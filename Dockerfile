FROM maven:3.9.3-eclipse-temurin-20 AS stage1
COPY ./ ./app-src
WORKDIR ./app-src
RUN mvn clean package

FROM eclipse-temurin:20-jre-alpine
COPY --from=stage1 ./app-src/*/target/*.jar ./app-jars/
WORKDIR ./app-jars
ENTRYPOINT ["java", "--module-path", ".", "--module", "language_learny/blabla.ahlberg.language_learny.Main"]
