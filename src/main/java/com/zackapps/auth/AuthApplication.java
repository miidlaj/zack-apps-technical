package com.zackapps.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "ZACK APPS TECHNICAL",
				version = "1.0",
				description = "Role based authentication and authorization.",
				contact = @Contact(
						name = "Muhammed Midlaj",
						email = "mumidlaj@gmail.com"
				),
				license = @License(
						name = "license",
						url = "license.com"
				)
		)
)
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

}
