FROM openjdk:17
ADD target/spring-redis-demo.jar spring-redis-demo.jar
EXPOSE 20112
ENTRYPOINT ["java","-jar","/spring-redis-demo.jar"]
