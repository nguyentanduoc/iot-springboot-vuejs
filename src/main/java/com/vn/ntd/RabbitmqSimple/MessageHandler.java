package com.vn.ntd.RabbitmqSimple;

import com.vn.ntd.RabbitmqSimple.model.MessageModel;
import com.vn.ntd.RabbitmqSimple.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

/**
 * The Class MessageHandler
 *
 * @author ntduoc
 * @since 6/3/2019
 */
@Component
public class MessageHandler {

    @Autowired
    private MessageRepository messageRepository;

    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public org.springframework.messaging.MessageHandler handler() {
        return message -> {
//            MessageModel messageModel = new MessageModel(  );
//            messageModel.setMessage(  message.getPayload().toString() );
//            messageRepository.save(messageModel);
            System.out.println( "!!!!!!!!!!!!!!!!!!!" + message.getPayload() );
        };
    }
}
