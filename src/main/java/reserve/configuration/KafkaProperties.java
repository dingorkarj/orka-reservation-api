package reserve.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("kafka")
public class KafkaProperties {

    @Value("${kafka.acks}")
    public String acks;

    @Value("${kafka.bootstrap.servers}")
    public String servers;

    @Value("${kafka.key.serializer}")
    private String keySerializer;

    @Value("${kafka.value.serializer}")
    private String valueSerializer;

    public String getBootStrapServers(){
        return servers;
    }

    public String getServers() {
        return servers;
    }

    public String getKeySerializer() {
        return keySerializer;
    }

    public String getValueSerializer() {
        return valueSerializer;
    }

    public String getAcks() {
        return acks;
    }
}
