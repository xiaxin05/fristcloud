package com.panshi.sm;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServerMain {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ServerMain.class).web(true).run(args);
	}

}
