package com.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**").allowedOriginPatterns("*") // Allow all origins
				.allowedMethods("*") // Allow all methods (GET, POST, PUT, DELETE, etc.)
				.allowedHeaders("*") // Allow all headers
				.allowCredentials(true) // Allow credentials (if needed)
				.maxAge(3600); // Max age for preflight (OPTIONS) requests
	}
}
