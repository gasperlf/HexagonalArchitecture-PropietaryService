package com.powerup.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@EnableFeignClients
@SpringBootApplication
public class PowerUpUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(PowerUpUserApplication.class, args);
	}

}
