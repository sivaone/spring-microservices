FROM maven:3.9-eclipse-temurin-17-alpine AS build

ARG mvn_user
ARG mvn_pwd

ENV MVN_REPO_USERNAME ${mvn_user}
ENV MVN_REPO_PASSWORD ${mvn_pwd}

WORKDIR /code/app/
COPY . .

# Package only generates jar. Use Deploy instead to publish artifacts to given repository
RUN mvn -B package -s settings.xml
# RUN mvn -B deploy -s settings.xml


FROM eclipse-temurin:17-jre-alpine

COPY --from=build /code/app/target/*.jar app.jar

EXPOSE 8888
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar ${0} ${@}"]
