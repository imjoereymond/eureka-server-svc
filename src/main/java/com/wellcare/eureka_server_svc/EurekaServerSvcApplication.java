package com.wellcare.eureka_server_svc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerSvcApplication.class, args);
	}

}
