package com.jcp.poc

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/*
 * Added to check jenkins auto deploy :)
 */
@SpringBootApplication
public class ExpCommRestApp {

    public static void main(String[] args) {
        SpringApplication.run(ExpCommRestApp.class, args);
    }
}
