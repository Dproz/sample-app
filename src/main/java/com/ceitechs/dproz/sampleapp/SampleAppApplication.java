package com.ceitechs.dproz.sampleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.ceitechs.dproz")
@EnableDiscoveryClient
public class SampleAppApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SampleAppApplication.class, args);
	}
}
