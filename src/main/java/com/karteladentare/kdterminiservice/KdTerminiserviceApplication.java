package com.karteladentare.kdterminiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication
@EnableEurekaClient
@EnableBinding(Source.class)
public class KdTerminiserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KdTerminiserviceApplication.class, args);
    }

}
