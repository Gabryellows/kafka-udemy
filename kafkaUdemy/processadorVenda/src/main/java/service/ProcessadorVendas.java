package service;

import deserializer.VendaDeserializer;
import model.Venda;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;

public class ProcessadorVendas {

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, VendaDeserializer.class.getName());
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "grupoProcessamento");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        try(KafkaConsumer<String, Venda> kafkaConsumer = new KafkaConsumer<String, Venda>(properties)) {

            kafkaConsumer.subscribe(Arrays.asList("vendaIngressos"));

            while(true) {
                ConsumerRecords<String, Venda> vendas = kafkaConsumer.poll(Duration.ofMillis(500));

                for (ConsumerRecord<String, Venda> record : vendas) {
                    Venda venda = record.value();
                    venda.setStatus(new Random().nextBoolean() ? "APROVADA" : "REPROVADA");
                    Thread.sleep(500);
                    System.out.println("Venda processada: " + venda);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
