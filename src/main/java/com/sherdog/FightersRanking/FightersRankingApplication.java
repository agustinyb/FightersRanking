package com.sherdog.FightersRanking;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FightersRankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FightersRankingApplication.class, args);
	}
	@Bean
	public OpenAPI customOpenApi(){
		return new OpenAPI()
				.info(new Info()
						.title("FightersRanking Api")
						.version("0.1")
						.description("aplicacion con el ranking de peleadores")
						.termsOfService("http://swagger.io/terms/")
						.license(new License().name("apache 2.0").url("http://springdoc.org"))
				);

	}
}
