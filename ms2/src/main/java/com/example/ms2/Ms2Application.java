package com.example.ms2;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class Ms2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ms2Application.class, args);
	}

	@Bean
	public ModelMapper mapper(){
		return new ModelMapper();
	}

}
