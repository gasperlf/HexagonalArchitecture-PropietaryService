package com.powerup.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PowerUpUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(PowerUpUserApplication.class, args);
	}

}
