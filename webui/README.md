## Introduction

Change the datasource in /WEB-INF/resources.xml file

mvn install

mvn clean package

## running in dev mode

mvn clean package tomee:run

This will create an executable jar file **cms.kodecamp-exec.jar** within the _target_ maven folder. This can be started by executing the following command

java -jar target/cms.kodecamp-exec.jar

To launch the test page, open your browser at the following URL

    http://localhost:8080/index.html
