package com.bank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.core.env.Environment;

import java.util.ArrayList;

@EnableConfigServer
@SpringBootApplication
public class ConfigApplication {



	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}

}
