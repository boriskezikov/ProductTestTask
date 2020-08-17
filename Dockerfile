FROM openjdk:11
RUN apt-get update && apt-get install -y unzip


WORKDIR /gradle
RUN curl -L https://services.gradle.org/distributions/gradle-6.5.1-bin.zip -o gradle-6.5.1-bin.zip
RUN unzip gradle-6.5.1-bin.zip
ENV GRADLE_HOME=/gradle/gradle-6.5.1
ENV PATH=$PATH:$GRADLE_HOME/bin

RUN cd ..
RUN mkdir /app
ADD . /app
WORKDIR /app

CMD exec gradle build
ENTRYPOINT [ "java","-jar","/app/build/libs/boot-0.0.1-SNAPSHOT.jar" ]
ADD build/libs/boot-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 8081
ENV JAVA_OPTS="-Duser.timezone=GMT -Dfile.encoding=UTF-8 -Denvironment.type=production"
CMD exec java $JAVA_OPTS -jar /app.jar