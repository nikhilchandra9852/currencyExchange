package com.springCloudServer.springCloudServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudServerApplication.class, args);
	}


}
