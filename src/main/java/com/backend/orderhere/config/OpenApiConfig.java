package com.backend.orderhere.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
  @Bean
  public OpenAPI usersMicroserviceOpenAPI() {
    return new OpenAPI()
        .info(new Info().title("OrderHere API")
            .description("OrderHere API reference for developers")
            .version("1.0"))
        .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
        .components(new Components().addSecuritySchemes("Bearer Authentication", createAPISchemes()));
  }

  private SecurityScheme createAPISchemes() {
    return new SecurityScheme().type(SecurityScheme.Type.HTTP)
        .bearerFormat("JWT")
        .scheme("bearer");
  }
}
