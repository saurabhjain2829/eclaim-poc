FROM openjdk:8-jdk-slim


RUN mkdir -p /app/logs /app/bin




COPY eclaim-processing-service/target/eclaim-processing-service.jar /app/eclaim-processing-service.jar

RUN chmod -R u=rwx,g=rwx,o=rwx /app
WORKDIR /app


CMD java \
  -Xms256m \
  -Xmx256m \
  -XX:MaxMetaspaceSize=128m \
  -verbose:gc \
  -XX:+PrintGCDetails \
  -XX:+PrintGCDateStamps \
  -Xloggc:/app/logs/gc.log \
  -XX:+UseGCLogFileRotation \
  -XX:NumberOfGCLogFiles=10 \
  -XX:GCLogFileSize=10M \
  -jar /app/eclaim-processing-service.jar \
  server
