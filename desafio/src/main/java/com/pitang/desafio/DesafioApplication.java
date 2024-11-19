package com.pitang.desafio;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(prePostEnabled = true,  securedEnabled = true,  jsr250Enabled = true)
@OpenAPIDefinition(
		info = @Info(
				title = "Aplicação Usuario-Carro (desafio Pitang)",
				description = "Aplicação Usuario-Carro REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Sérgio Alves Bezerra",
						email = "sergiobezerra02@gmail.com",
						url = "https://www.linkedin.com/in/sergioalvesbezerra/"
				),
				license = @License(name = "Apache 2.0",
						url = "https://www.eazybytes.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Aplicação Usuario-Carro REST API Documentation",
				url= "https://github.com/sergiobezerradesafiopitang/desafio_pitang"
		)

)
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

}
