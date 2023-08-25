package service;

import model.Venda;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import serializer.VendaSerializer;

import java.math.BigDecimal;
import java.util.Properties;
import java.util.Random;

public class GeradorVendas {

    private static Random rand = new Random();
    private static long controleOperacao = 0;
    private static BigDecimal valorTotal = BigDecimal.valueOf(500);

    public static void main(String[] args){

        Properties properties = new Properties();

        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, VendaSerializer.class.getName());

        try (KafkaProducer<String, Venda> kafkaProducer = new KafkaProducer<String, Venda>(properties)) {
            while(true) {
                Venda venda = gerarVenda();
                ProducerRecord<String, Venda> record = new ProducerRecord<String, Venda>("vendaIngressos", venda);
                kafkaProducer.send(record);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static Venda gerarVenda() {
        long codigoCliente = rand.nextLong();
        int quantidadeIngressos = rand.nextInt(10);
        BigDecimal valorTotalIngressoxQuantidade = valorTotal.multiply(BigDecimal.valueOf(quantidadeIngressos));
        String status = "NOVA";

        return new Venda(controleOperacao++, codigoCliente, quantidadeIngressos, valorTotalIngressoxQuantidade, status);
    }
}

