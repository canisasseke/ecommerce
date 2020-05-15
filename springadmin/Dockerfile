#################
# Build the app #
#################
#FROM maven:3-openjdk-11-slim AS MAVEN_BUILD
#COPY pom.xml /build/
#COPY src /build/src/
#WORKDIR /build/
#RUN mvn -DSkipTests clean package -P prod 

#########################
# Build image #
#########################
FROM openjdk:11-jre-slim
VOLUME /tmp
#RUN apt-get update && \ #apt-get install -y netcat;
ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh wait-for-it.sh
RUN bash -c 'chmod +x wait-for-it.sh'
ENV APP_HOME /usr/apps
ENV APP_FILE springadmin-0.0.1-SNAPSHOT.jar
ENV SPRING_PROFILES_ACTIVE docker
WORKDIR $APP_HOME
EXPOSE 9500
#COPY --from=MAVEN_BUILD /build/target/${APP_FILE} $APP_HOME/
COPY target/${APP_FILE} $APP_HOME/
ENTRYPOINT ["/bin/sh"]
CMD ["-c java -jar $APP_FILE"]