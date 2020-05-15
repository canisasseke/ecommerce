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
ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh wait-for-it.sh
RUN bash -c 'chmod +x wait-for-it.sh'
ENV APP_HOME /usr/apps
ENV APP_FILE ecommerce-config-server-0.0.1-SNAPSHOT.jar
WORKDIR $APP_HOME
EXPOSE 8888
#COPY --from=MAVEN_BUILD /build/target/${APP_FILE} $APP_HOME/
COPY target/${APP_FILE} $APP_HOME/
#ENTRYPOINT ["java", "-jar","/usr/apps/ecommerce-config-server-0.0.1-SNAPSHOT.jar"]
CMD ["java", "-jar","/usr/apps/ecommerce-config-server-0.0.1-SNAPSHOT.jar"]
#ENTRYPOINT ["sh", "-c"]
#CMD ["exec java -jar $APP_FILE"]