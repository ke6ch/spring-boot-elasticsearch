# SpringBoot, Elasticsearch

```
docker-compose up
curl -H "Content-Type: application/json" -XPUT localhost:9200/_template/population --data-binary @template.json

java -jar ./target/spring-boot-elasticsearch-0.0.1-SNAPSHOT.jar
curl localhost:8080/
curl localhost:8080/population
```

## Data
[RESAS](https://resas.go.jp/)
