package serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Venda;
import org.apache.kafka.common.serialization.Serializer;

public class VendaSerializer implements Serializer<Venda> {
    @Override
    public byte[] serialize(String topic, Venda venda) {
        try {
            return new ObjectMapper().writeValueAsBytes(venda);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
