FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

WORKDIR /usr/share/vinh

# ADD .jar & libs files under target from host
COPY target/framework-1.0.jar 						framework-1.0.jar
COPY target/framework-1.0-tests.jar					framework-1.0-tests.jar
COPY target/libs									libs

# ADD resources folder
COPY src/test/resources				   				src/test/resources

# ADD suite files
COPY src/test/resources/suites/suite.xml			suite.xml

# ADD bash file for execution
COPY healthcheck.sh									healthcheck.sh

ENTRYPOINT sh healthcheck.sh
