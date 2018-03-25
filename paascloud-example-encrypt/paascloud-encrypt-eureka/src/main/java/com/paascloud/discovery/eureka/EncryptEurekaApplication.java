package com.paascloud.discovery.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * The class Encrypt eureka application.
 *
 * @author paascloud.net @gmail.com
 */
@EnableEurekaServer
@SpringBootApplication
public class EncryptEurekaApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(EncryptEurekaApplication.class, args);
	}
}
