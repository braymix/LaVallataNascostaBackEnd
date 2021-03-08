package com.LaVallataNascostaBack.LaValle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FilterCorsConfig {
	@Bean
	public WebMvcConfigurer corsConfigurer()
	{
		return new WebMvcConfigurer()
		{
			@Override
			public void addCorsMappings(CorsRegistry registry)
			{
				
				registry
					.addMapping("/**")
					.allowedOrigins("*")
					.allowedMethods( "DELETE", "GET", "POST" ,"PATCH","PUT")
					.allowedHeaders("*")
					.exposedHeaders("header1", "header2")
					.allowCredentials(false)
					.maxAge(3600);
			}
		};
	}
}