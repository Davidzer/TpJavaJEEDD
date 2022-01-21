package com.rdWebservice.thirdWebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ThirdWebServiceApplication {

	@Autowired

	DiscoveryClient discoveryClient;

	@GetMapping("/")
	public String hello() {

		List<ServiceInstance> instances = discoveryClient.getInstances("TpMicroserv");
		ServiceInstance test = instances.get(0);
		String hostname = test.getHost();
		int port = test.getPort();

		RestTemplate restTemplate = new RestTemplate();
		String microservice1Adress = "http://" + hostname + ":" + port;
		ResponseEntity<String> response = restTemplate.getForEntity(microservice1Adress, String.class);
		String s = response.getBody();

		return s;

	}



}
