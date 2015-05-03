FROM java:7
VOLUME /tmp
ADD build/libs/myproject-0.0.1-SNAPSHOT.jar myproject-0.0.1-SNAPSHOT.jar
RUN bash -c 'touch /myproject-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myproject-0.0.1-SNAPSHOT.jar"]
