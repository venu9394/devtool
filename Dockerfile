FROM openjdk:11
ADD target/springbootapp.jar springbootapp.jar
EXPOSE 9094
ENTRYPOINT ["java","-jar","springbootapp.jar"]
