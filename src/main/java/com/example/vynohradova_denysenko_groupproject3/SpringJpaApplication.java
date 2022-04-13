package com.example.vynohradova_denysenko_groupproject3;

import Service.HRManagerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = {HRManagerService.class})
@EntityScan("Model")
@EnableJpaRepositories("Repository")
public class SpringJpaApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);
        HRManagerService hrManagerService = (HRManagerService) context.getBean("hrManagerService");
    }
}