package com.y39.bindingofplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BindingOfPlannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BindingOfPlannerApplication.class, args);
    }

}
