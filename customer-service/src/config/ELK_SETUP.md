## ELK Setup

#### Pre-requisites

* Docker Desktop

#### On windows, increase vm map count by running below commands

~~~
wsl -d docker-desktop

sysctl -w vm.max_map_count=262144

exit
~~~

#### Steps to install and configure ELK stack

1. Create network and Run ElasticSearch Container
~~~
docker network create elastic

docker run --name elasticsearch --net elastic -p 9200:9200 -it --hostname elasticsearch docker.elastic.co/elasticsearch/elasticsearch:8.5.3
~~~
2. Copy password and kibana token from console and test connectivity 
~~~
docker cp elasticsearch:/usr/share/elasticsearch/config/certs/http_ca.crt .

curl --cacert http_ca.crt -u elastic https://localhost:9200
~~~
3. If password is not auto generated, you can reset by logging into container shell using below command
~~~
cd /usr/share/elasticsearch
./bin/elasticsearch-reset-password -u elastic
~~~
4. If token is not auto generated, you can generate a token by logging into container shell using below command
~~~
cd /usr/share/elasticsearch
./bin/elasticsearch-create-enrollment-token --scope kibana
~~~
5. Run Kibana Container
~~~
docker run --name kibana --net elastic -p 5601:5601 -H kibana docker.elastic.co/kibana/kibana:8.5.3
~~~
4. Open localhost:5601 from web browser and register elasticsearch with Kibana using the token from elasticsearch console
5. Login to Kibana with username: elastic, pwd: from console
6. Download and run logstash locally with config provided in src/config/logstash.conf
~~~
cd (path of logstash)
./bin/logstash -f (path)/logstash.conf
~~~
7. Use the input tcp port from logstash in spring-logback.xml to stream logs to elk stack
