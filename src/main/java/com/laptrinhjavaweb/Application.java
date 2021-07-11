package com.laptrinhjavaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Application {
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
// loi mapping in hibernate 