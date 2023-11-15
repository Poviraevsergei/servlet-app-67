FROM openjdk:17-alpine
ARG JAR_FILE=target/servlet-app-67.jar
RUN mkdir /c67
WORKDIR /c67
COPY ${JAR_FILE} /c67
ENTRYPOINT [ "java", "-jar" ,"/c67/servlet-app-67.jar"]