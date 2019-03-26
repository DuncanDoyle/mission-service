Emergency response Mission Service [![Build Status](https://travis-ci.org/NAPS-emergency-response-project/mission-service?branch=master)](https://travis-ci.org/NAPS-emergency-response-project/mission-service)
=========

Pre-requisites: Running Kafka Cluster, JDG Service, Configmap

To deploy the service to a running single-node OpenShift cluster:

   ```
$ oc login -u developer -p developer

$ oc new-project MY_PROJECT_NAME

$ mvn clean fabric8:deploy -Popenshift

   ```

== More Information
You can learn more about this booster and rest of the Eclipse Vert.x runtime in the link:http://launcher.fabric8.io/docs/vertx-runtime.html[Eclipse Vert.x Runtime Guide].

NOTE: Run the set of integration tests included with this booster using `mvn clean verify -Popenshift,openshift-it`.


Following ConfigMap needs to exist which is mounted to /deployments/config/app-config-properties via fabric8:deploy
NAME: mission-service
Key: app-config.properties

   ```
kafka.connect=localhost:9092
kafka.sub=MissionCreateCommand
kafka.pub=MissionUpdatedCommand
jdg.svc.name=datagrid-service
jdg.port=11222
jdg.app.name=datagrid-service
jdg.app.user.name=demo
jdg.app.user.password=demo
http.host=localhost
http.port=8080
   ```

