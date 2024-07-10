package br.gov.go.sefaz.agualegal.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi externalApi() {
		return GroupedOpenApi.builder().group("externos")
				.packagesToScan("br.gov.go.sefaz.agualegal.controller.externos").build();
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title("Agua Legal API").version("1.0")
				.description("Documentação da API do projeto Agua Legal").termsOfService("http://swagger.io/terms/")
				.contact(new Contact().name("Suporte API").url("http://www.sefaz.go.gov.br")
						.email("suporte@sefaz.go.gov.br"))
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
