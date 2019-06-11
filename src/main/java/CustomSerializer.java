import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class CustomSerializer implements Serializer {


    public void configure(Map configs, boolean isKey) {

    }

    public byte[] serialize(String topic, Object data) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            System.out.println("========1=======");
            retVal = objectMapper.writeValueAsString(data).getBytes();
        } catch (Exception exception) {
            System.out.println("Error in serializing object"+ data);
        }
        return retVal;
    }

    public void close() {

    }
}
