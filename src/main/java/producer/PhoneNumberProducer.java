package producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class PhoneNumberProducer {

    private Properties props;

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

//        props.put("bootstrap.servers", "localhost:9092");
//        props.put("acks", "all");
//        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

    public void sendPhoneNumber(String s){
        Producer<String, String> producer = new KafkaProducer<>(props);
        producer.send(new ProducerRecord<String, String>("phoneNumber", s, s));
        producer.close();
    }

}
