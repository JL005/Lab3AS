FROM adoptopenjdk/openjdk11
COPY lab3-0.0.1-SNAPSHOT.jar /usr/src/bootdocker/app.jar
WORKDIR /usr/src/bootdocker
EXPOSE 8089
ENTRYPOINT ["java","-jar","/usr/src/bootdocker/app.jar"]
