## Instructions to start Camunda 8 on local
- https://camunda.com/blog/2023/10/camunda-self-managed-for-absolute-beginners/

## Running C8 cluster
- For the first time, follow instruction the c8-self-managed folder
- Start Docker desktop
- Runner Docker images
- Operate http://localhost:8081
- Tasklist http://localhost:8082/
- Cluster endpoint/gateway http://0.0.0.0:26500

## Downloading Camunda 8 Run
### Linux
- `sudo apt install openjdk-21-jdk`  
- `echo 'export JAVA_HOME="/usr"' >> ~/.bashrc`
- `echo 'export ES_JAVA_HOME="/usr"' >> ~/.bashrc`  
- `wget https://github.com/camunda/camunda/releases/download/c8run-8.6.2/camunda8-run-8.6.2-linux-x86_64.tar.gz`
- `tar -xvzf camunda8-run-8.6.2-linux-x86_64.tar.gz`

### Windows
- Install JDK 21+
- Set environment variables JAVA_HOME and JAVA_VERSION
- Download https://github.com/camunda/camunda/releases/tag/c8run-8.6.2
- Extract the archive

## Starting Camunda 8
### Linux
- `source c8run/start.sh`

### Windows
- `c8run\c8run.exe start`

## Starting Kafka on Windows
- `kafka\bin\windows\zookeeper-server-start.bat kafka\config\zookeeper.properties`
- `kafka\bin\windows\kafka-server-start.bat kafka\config\server.properties`

- `kafka\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic camunda-kafka-topic`
- `kafka\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic camunda-kafka-topic --from-beginning`  

## Starting Kafka on Linux
- `kafka/bin/zookeeper-server-start.sh kafka/config/zookeeper.properties`  
- `kafka/bin/kafka-server-start.sh kafka/config/server.properties`  
- `kafka/bin/kafka-console-producer.sh --broker-list localhost:9092 --topic camunda-kafka-topic`  
- `kafka/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic camunda-kafka-topic --from-beginning`

## Starting the Connector Runtime
- `docker pull camunda/connectors-bundle:8.5.0`  
- `docker compose up -d`  

## Enable logs
- `docker logs -f kafka-connector-runtime` 
- my-camunda-kafka-setup-kafka-connector-runtime-1

# TO-DO
- Kafka
- gRPC
- REST
- LDAP

# Learning resources
- https://github.com/camunda-community-hub/kafka-connect-zeebe/blob/main/docker/docker-compose-local-kafka.yml
- https://www.youtube.com/watch?v=SqVfCyfCJqw
- https://www.youtube.com/watch?v=BwYFuhVhshI&t=467s

