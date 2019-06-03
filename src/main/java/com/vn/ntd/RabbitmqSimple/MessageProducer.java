package com.vn.ntd.RabbitmqSimple;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.plugin2.message.Message;

import java.util.Date;
import java.util.UUID;

/**
 * The Class MessageProducer
 *
 * @author ntduoc
 * @since 6/3/2019
 */
//@Component
public class MessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void produce() {
        rabbitTemplate.convertAndSend( "timer.exchange", "timer.routing.key", "111111111111111111" );
    }
}
