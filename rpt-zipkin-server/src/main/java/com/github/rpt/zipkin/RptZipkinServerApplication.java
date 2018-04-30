package com.github.rpt.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class RptZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RptZipkinServerApplication.class, args);
    }
}
