package com;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
@EnableConfigServer
public class Application_9001 {
    public static void main(String[] args) {
        SpringApplication.run(Application_9001.class,args) ;
    }
}