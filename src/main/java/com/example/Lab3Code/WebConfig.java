package com.example.Lab3Code;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // This class provides custom Spring MVC configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            // 1. Enable CORS (Cross-Origin Resource Sharing) for /api/** endpoints
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Applies CORS to all /api/ paths
                        // .allowedOrigins() can be specified if needed
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }

            // 2. Map the /students path to the "Frontend.html" Thymeleaf view
            @Override
            public void addViewControllers(
                    org.springframework.web.servlet.config.annotation.ViewControllerRegistry registry) {
                registry.addViewController("/students").setViewName("Frontend");
                // This means: accessing /students will return templates/Frontend.html
            }
        };
    }
}