#!/bin/bash

java \
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
  -jar ./eclaim-processing-service/target/eclaim-processing-service.jar \
  server
