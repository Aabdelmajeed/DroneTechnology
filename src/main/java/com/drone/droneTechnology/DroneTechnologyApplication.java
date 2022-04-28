package com.drone.droneTechnology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DroneTechnologyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DroneTechnologyApplication.class, args);
    }

}
