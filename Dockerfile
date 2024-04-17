# temp container to build using gradle
FROM gradle:7.6.4 AS TEMP_BUILD_IMAGE
RUN echo "--------------------------------"
RUN echo "------BUILD IMAGE DEI---------"
RUN echo "--------------------------------"
RUN mkdir -p /app/
WORKDIR /app/
COPY ../../../Users/marel/Downloads /app/
USER root
RUN chown -R gradle .
# RUN gradle runDev
RUN gradle :back-prueba:build -x test

# actual container
FROM openjdk:17
RUN mkdir -p /app/config
COPY /build/libs/back-prueba-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app/build/libs/back-prueba-0.0.1-SNAPSHOT.jar"]