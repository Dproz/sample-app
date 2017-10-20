FROM openjdk:9-jdk

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    SLEEP=10 \
    JAVA_OPTS=""

ADD *SNAPSHOT.jar /app.jar

EXPOSE 8080
CMD echo "The application will start in ${SLEEP}s..." && \
    sleep ${SLEEP} && \
    java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar
