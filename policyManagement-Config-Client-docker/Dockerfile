FROM openjdk:8-alpine
VOLUME /tmp
EXPOSE 8082
ADD target/*.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar"]