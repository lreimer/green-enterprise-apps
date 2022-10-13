FROM gradle:7.5.1-jdk17 as build

WORKDIR /app/
ADD . /app/

RUN ./gradlew ass --no-daemon

FROM gcr.io/distroless/java17-debian11

ENV PORT=8080

COPY --from=build /app/build/libs/green-enterprise-java.jar /

WORKDIR /
ENTRYPOINT [ "java", "-cp", "green-enterprise-java.jar", "green.enterprise.app.Microservice"]
