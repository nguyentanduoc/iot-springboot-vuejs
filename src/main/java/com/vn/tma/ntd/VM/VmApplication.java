package com.vn.tma.ntd.VM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.integration.annotation.IntegrationComponentScan;

/**
 * The type Vm application.
 */
@Configuration
@ComponentScan
@EnableJpaAuditing
@EnableAutoConfiguration
@IntegrationComponentScan
public class VmApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run( VmApplication.class, args );
    }

}
