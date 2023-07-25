FROM openjdk:17-jdk-alpine

RUN mkdir /files

COPY persons.csv /files/

COPY target/SpringBatchChunk-0.0.1-SNAPSHOT.jar SpringBatch_Chunk.jar

RUN chmod -R 777 /files

WORKDIR /

ENTRYPOINT ["java", "-jar", "/SpringBatch_Chunk.jar"]




