## ELK Setup

#### Pre-requisites

* Docker Desktop

#### Steps to install and configure ELK stack

1. Run ElasticSearch Container
~~~
docker run --name elasticsearch --net elastic -p 9200:9200 -it -H elasticsearch docker.elastic.co/elasticsearch/elasticsearch:8.5.2
~~~
2. Copy password and kibana token from console and test connectivity 
~~~
docker cp elastic-01:/usr/share/elasticsearch/config/certs/http_ca.crt .

curl --cacert http_ca.crt -u elastic https://localhost:9200
~~~
3. Run Kibana Container
~~~
docker run --name kibana --net elastic -p 5601:5601 -H kibana docker.elastic.co/kibana/kibana:8.5.2
~~~
4. Open localhost:5601 from web browser and register elasticsearch with Kibana using the token from elasticsearch console
5. Login to Kibana with elastic/<pwd from console>
6. Download and run logstash locally with config provided in src/config/logstash.conf
~~~
./bin/logstash -f logstash.conf
~~~
7. Use the input tcp port from logstash in spring-logback.xml to stream logs to elk stack
