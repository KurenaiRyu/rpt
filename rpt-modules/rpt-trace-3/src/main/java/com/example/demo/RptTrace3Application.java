package com.example.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringCloudApplication
public class RptTrace3Application {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate  restTemplate;

    private final Logger logger = Logger.getLogger(getClass());

    @GetMapping("/trace")
    public String trace() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    @GetMapping("/trace-1")
    public String trace1() {
        logger.info("===<call trace-3>===");
        return restTemplate.getForEntity("http://trace-1/trace-1", String.class).getBody();
    }

    public static void main(String[] args) {
        SpringApplication.run(RptTrace3Application.class, args);
    }
}
