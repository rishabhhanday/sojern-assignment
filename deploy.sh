oc new-build java --name=sojern-assignment --binary=true
mvn clean install -DskipTests
oc start-build bc/sojern-assignment --from-file=target/assignment-0.0.1-SNAPSHOT.jar --follow
oc apply -f oc/deploy.yaml
oc scale -f oc/deploy.yaml --replicas=0
oc scale -f oc/deploy.yaml --replicas=1
oc apply -f oc/cluster-ip.yaml
oc expose -f oc/cluster-ip.yaml