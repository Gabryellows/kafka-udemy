# kafka-udemy
<h2>
  Apache Kafka para iniciantes
</h2>

<img alt="Banner Kafka" src="./assets/apache_kafka.png" width="950" height="400"/>


A subida do kafka e do zookeeper foi feita por conteinerização;

Foi feita uma simulação de um site de venda de ingressos, onde são disparadas muitas requisições de compras, foi criador o topic, producer e o respectivo consumer, 
separado em dois projetos.

realSimulationKafka contém o producer; <br>
processorVenda contém o consumer; <br>
o topic foi criado via CLI: <br> 
< kafka-topics --boostrap-server [ip_definido:porta_definida] --topic <name_topic> --create [se quiser já criar particões, adicionar o comando: --partitions <numero_de_partições> [se quiser criar replicações, adicionar o comando: --replication-factor <numero_replicações>] >

Obs: a porta se for subir via docker é <29092>. 
