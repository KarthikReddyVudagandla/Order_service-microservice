FROM openjdk:8-jdk-alpine

VOLUME /tmp

COPY ./target/orderService-1.0-SNAPSHOT.jar /orderService.jar

WORKDIR /

EXPOSE 8081

CMD [ "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /orderService.jar" ]