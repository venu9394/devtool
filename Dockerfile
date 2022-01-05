FROM openjdk:11
ADD taret/springbootapp.jar springbootapp.jar
EXPOSE 9094
ENTRYPOINT ["java","-jar","springbootapp.jar"]
