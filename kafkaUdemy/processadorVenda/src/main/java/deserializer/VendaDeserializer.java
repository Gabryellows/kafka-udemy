package deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Venda;
import org.apache.kafka.common.serialization.Deserializer;

public class VendaDeserializer implements Deserializer<Venda> {
    @Override
    public Venda deserialize(String topic, byte[] venda) {
        try {
            return new ObjectMapper().readValue(venda, Venda.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
