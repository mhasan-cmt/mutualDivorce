package com.project.mutualDivorce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.project.mutualDivorce")

@EnableJpaRepositories
public class MutualDivorceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutualDivorceApplication.class, args);
	}


}
