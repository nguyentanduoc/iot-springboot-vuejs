package com.vn.ntd.RabbitmqSimple;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The Class ProducerConfig
 *
 * @author ntduoc
 * @since 6/3/2019
 */
//@Configuration
public class ProducerConfig {

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange( "timer.exchange" );
    }

    @Bean
    public Queue queue() {
        return QueueBuilder.durable( "timer.queue" ).build();
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange directExchange) {
        return BindingBuilder.bind( queue ).to( directExchange ).with( "timer.routing.key" );
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate( connectionFactory );
        rabbitTemplate.setMessageConverter( jackson2JsonMessageConverter() );
        return rabbitTemplate;
    }

    private Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
