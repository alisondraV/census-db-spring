package com.example.vynohradova_denysenko_groupproject3;

import Service.HRManagerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main class of the application
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = { HRManagerService.class })
@EntityScan("Model")
@EnableJpaRepositories("Repository")
public class SpringJpaApplication {
    /**
     * @param args Cmd arguments
     *
     * Entrypoint of the application
     */
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);
        HRManagerService hrManagerService = (HRManagerService) context.getBean("hrManagerService");
        hrManagerService.test();
    }
}