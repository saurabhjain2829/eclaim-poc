FROM openjdk:8-jdk-slim


RUN mkdir -p /app/logs /app/bin

COPY config/startup.sh /app/bin

RUN chmod -R u=rwx,g=rwx,o=rwx /app


COPY eclaim-processing-service/target/eclaim-processing-service.jar /app/eclaim-processing-service.jar

WORKDIR /app


CMD ["/bin/sh", "-c", "/app/bin/startup.sh"]
