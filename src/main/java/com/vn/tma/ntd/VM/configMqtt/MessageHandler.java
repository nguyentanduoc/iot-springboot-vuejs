package com.vn.tma.ntd.VM.configMqtt;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * The Class MessageHandler
 *
 * @author ntduoc
 * @since 6/11/2019
 */
@Configurable
public class MessageHandler {

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
