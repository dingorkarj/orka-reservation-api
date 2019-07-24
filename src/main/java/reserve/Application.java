package reserve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reserve.configuration.KafkaProperties;
import reserve.producer.PhoneNumberProducer;

import java.util.Arrays;
import java.util.Properties;

@SpringBootApplication
public class Application {

    @Autowired
    public KafkaProperties kafkaProps;

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }

    @Bean
    public PhoneNumberProducer phoneNumberProducer(){
        PhoneNumberProducer phoneNumberProducer = new PhoneNumberProducer();
        Properties props = new Properties();
        props.put("bootstrap.servers", kafkaProps.getBootStrapServers());
        props.put("acks", kafkaProps.getAcks());
        props.put("key.serializer", kafkaProps.getKeySerializer());
        props.put("value.serializer", kafkaProps.getValueSerializer());
        phoneNumberProducer.setProps(props);
        return phoneNumberProducer;
    }
}
