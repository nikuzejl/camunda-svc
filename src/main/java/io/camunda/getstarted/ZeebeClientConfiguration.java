//package io.camunda.getstarted;
//
//import io.camunda.zeebe.client.ZeebeClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ZeebeClientConfiguration {
//
//    @Bean
//    public ZeebeClient zeebeClient() {
//        return ZeebeClient.newClientBuilder()
//                .gatewayAddress("0.0.0.0:26500")
//                .usePlaintext()
//                .build();
//    }
//}