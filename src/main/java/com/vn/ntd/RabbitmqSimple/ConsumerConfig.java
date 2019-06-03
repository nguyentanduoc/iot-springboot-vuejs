package com.vn.ntd.RabbitmqSimple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

/**
 * The Class ConsumerConfig
 *
 * @author ntduoc
 * @since 6/3/2019
 */
//@Configuration
//@EnableRabbit
public class ConsumerConfig implements RabbitListenerConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger( ConsumerConfig.class );

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory( defaultMessageHandlerMethodFactory() );
    }

    public DefaultMessageHandlerMethodFactory defaultMessageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory defaultMessageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory();
        defaultMessageHandlerMethodFactory.setMessageConverter( mappingJackson2MessageConverter() );
        return defaultMessageHandlerMethodFactory;
    }

    private MappingJackson2MessageConverter mappingJackson2MessageConverter() {
        return new MappingJackson2MessageConverter();
    }

    @RabbitListener(queues = "timer.queue")
    public void consume(String message) {
        LOGGER.info( "Payload {} ", message );
    }
}
