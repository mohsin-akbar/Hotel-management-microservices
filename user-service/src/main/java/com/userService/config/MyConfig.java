package com.userService.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {
    @Bean
    @LoadBalanced
    //for name change of port and host ,service-name instead of localhost:port  agr aap port name
    //agar ham application .properties me port change bhi kar de to isse koi fark nahi padega ap service call kar skte hai kisi port par

    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
