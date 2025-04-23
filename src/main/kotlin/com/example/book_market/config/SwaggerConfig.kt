package com.example.book_market.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun userApi() = OpenAPI()
        .info(Info().title("Book Market API")
        .description("API documentation for Book Market application")
        .version("1.0.0"))
}