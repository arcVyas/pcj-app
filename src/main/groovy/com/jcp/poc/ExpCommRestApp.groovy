package com.jcp.poc

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.web.SpringBootServletInitializer
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import com.jcp.poc.controllers.CouponController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.ComponentScan;
/*
 * Added to check jenkins auto deploy :)
 */
@SpringBootApplication
public class ExpCommRestApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ExpCommRestApp.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ExpCommRestApp.class);
    }
}
