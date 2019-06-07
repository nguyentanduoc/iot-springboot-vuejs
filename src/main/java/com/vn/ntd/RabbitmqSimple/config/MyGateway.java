package com.vn.ntd.RabbitmqSimple.config;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

@Component
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MyGateway {
    void sendToMqtt(String data);
}
