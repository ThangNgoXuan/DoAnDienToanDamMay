FROM openjdk:latest
ADD target/qlsv-mysql.jar qlsv-mysql.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","qlsv-mysql.jar"]