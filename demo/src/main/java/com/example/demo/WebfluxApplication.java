package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: lcc
 * @Date: 2018-05-15
 **/
@Slf4j
@SpringBootApplication
@EnableReactiveMongoRepositories
public class WebfluxApplication {

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication app = new SpringApplication(WebfluxApplication.class);
		Environment env = app.run(args).getEnvironment();
		log.info("Access URLs:\n----------------------------------------------------------\n\t" +
						"Local: \t\thttp://localhost:{}{}\n\t" +
						"External: \thttp://{}:{}{}\n----------------------------------------------------------",
				env.getProperty("server.port"),
				env.getProperty("server.servlet.contextPath"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"),
				env.getProperty("server.servlet.contextPath"));
	}
}
