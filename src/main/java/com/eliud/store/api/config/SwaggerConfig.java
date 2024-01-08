package com.eliud.store.api.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenApi(){
        return new OpenAPI()
                .components(new Components())
                .info(
                        new Info()
                                .title("Store API")
                                .description("API for get prices")
                );
    }
}
