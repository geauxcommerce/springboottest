FROM java:8
VOLUME /tmp
ADD build/libs/springboottest-0.0.1-SNAPSHOT.jar springboottest-0.0.1-SNAPSHOT.jar
RUN bash -c 'touch /springboottest-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springboottest-0.0.1-SNAPSHOT.jar"]
