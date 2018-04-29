package com.github.rpt.trace;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@SpringCloudApplication
public class TraceApplication {

    private final Logger logger = Logger.getLogger(getClass());

    @GetMapping(value = "/trace-1")
    public String trace() {
        logger.info("===<call trace-1>===");
        return "Trace";
    }

    @GetMapping(value = "/api/trace-1")
    public String trace2() {
        logger.info("===<call trace-2>===");
        return "Trace";
    }

    public static void main(String[] args) {
        SpringApplication.run(TraceApplication.class, args);
    }
}
