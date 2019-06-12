package com.vn.tma.ntd.VM.configMqtt;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;

/**
 * The Class MqttConfig
 *
 * @author ntduoc
 * @since 6/11/2019
 */
@Configuration
public class MqttConfig {

    @Value("${spring.mqtt.serverURI}")
    private String serverURI;

    @Value("${spring.mqtt.username}")
    private String username;

    @Value("${spring.mqtt.password}")
    private String password;

    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setServerURIs( new String[]{serverURI} );
        mqttConnectOptions.setUserName( username );
        mqttConnectOptions.setPassword( password.toCharArray() );
        factory.setConnectionOptions( mqttConnectOptions );
        return factory;
    }

    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageProducer inbound() {
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter( "testMqtt", mqttClientFactory(),
                        "test" );
        adapter.setCompletionTimeout( 5000 );
        adapter.setConverter( new DefaultPahoMessageConverter() );
        adapter.setQos( 1 );
        adapter.setOutputChannel( mqttInputChannel() );
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MqttPahoMessageHandler mqttOutbound() {
        MqttPahoMessageHandler messageHandler =
                new MqttPahoMessageHandler( "testClient", mqttClientFactory() );
        messageHandler.setAsync( true );
        messageHandler.setDefaultTopic( "test" );
        return messageHandler;
    }

    @Bean
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }
}
