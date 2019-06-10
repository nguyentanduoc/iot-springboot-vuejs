package com.vn.ntd.RabbitmqSimple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.integration.annotation.IntegrationComponentScan;

/**
 * The type Rabbitmq simple application.
 *
 * @author ntduoc
 * @since 6 /3/2019
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@IntegrationComponentScan
@EnableJpaAuditing
public class RabbitmqSimpleApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run( RabbitmqSimpleApplication.class, args );
    }
}
