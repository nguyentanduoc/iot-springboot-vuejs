package com.vn.tma.ntd.VM.configMqtt;

import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

/**
 * The Class Gateway
 *
 * @author ntduoc
 * @since 6/11/2019
 */
@Configuration
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface Gateway {
    void sendToMqtt(String data);
}
