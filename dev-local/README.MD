### Interacting with Kafka using AVRO Records

#### Produce AVRO Messages

- This  command should take care of logging in to the Schema Registry container.

```
docker exec -it schema-registry bash
```

- Run the **kafka-avro-console-producer** with the Schema

```
kafka-avro-console-producer --broker-list broker:29092 --topic greetings --property value.schema='{"type": "record","name":"Greeting","fields": [{"name": "greeting","type": "string"}]}'
```

- Publish the **Greeting** message

```
{"greeting": "Good Morning!, AVRO"}
```

```
{"greeting": "Good Evening!, AVRO"}
```

```
{"greeting": "Good Night!, AVRO"}
```

### Consume AVRO Messages

- This  command should take care of logging in to the Schema Registry container.

```
docker exec -it schema-registry bash

```

- Run the kafka-avro-console-consumer

```
kafka-avro-console-consumer --bootstrap-server broker:29092 --topic greetings --from-beginning
```

## Kafka Helpful Commands

- To view the list of topics in the Kafka environment.

```
kafka-topics --bootstrap-server localhost:9092 --describe
```

- **Note :** Schemas are stored in an internal topic named *_schemas**

- Lets view the configuration set up for **_schemas** topics

```
kafka-topics --bootstrap-server localhost:9092 --describe --topic _schemas
```

============================================
control center : http://localhost:9021/clusters

swagger: http://localhost:8090/swagger-ui/index.html

topic name : http://localhost:8081/subjects

schema registry validation : http://localhost:8081/subjects/avro-test-topic-value/versions/latest

{
"id": "23",
"firstName": "S",
"middleName": "O",
"lastName": "P",
"emailId": "sop@gmail.com"
}
