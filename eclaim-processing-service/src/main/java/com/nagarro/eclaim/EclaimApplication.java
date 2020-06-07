package com.nagarro.eclaim;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.eclaim.constants.Constants;
import com.nagarro.eclaim.dto.UserMessage;
import com.nagarro.eclaim.exceptions.handler.GlobalExceptionHandler;

@EnableJpaRepositories(basePackages="com.nagarro")
@SpringBootApplication(scanBasePackages="com.nagarro")
@EnableAspectJAutoProxy
@EntityScan(basePackages="com.nagarro")
@RestController
@Import(GlobalExceptionHandler.class)


public class EclaimApplication {

	public static void main(String[] args) {
		SpringApplication.run(EclaimApplication.class, args);

	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserMessage ping() {
		return new UserMessage(Constants.SUCCESS_CODE, Constants.UP);
	}

}
