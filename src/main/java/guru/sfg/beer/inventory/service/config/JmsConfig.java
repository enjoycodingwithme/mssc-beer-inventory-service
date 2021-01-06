package guru.sfg.beer.inventory.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConfig {

    @Bean
    public MessageConverter messageConverter(){
        MappingJackson2MessageConverter mapping = new MappingJackson2MessageConverter();
        mapping.setTargetType(MessageType.TEXT);
        mapping.setTypeIdPropertyName("_type");
        return mapping;
    }
}
