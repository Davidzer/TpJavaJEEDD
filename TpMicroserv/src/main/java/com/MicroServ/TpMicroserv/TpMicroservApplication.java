package com.MicroServ.TpMicroserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TpMicroservApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpMicroservApplication.class, args);
	}

}
