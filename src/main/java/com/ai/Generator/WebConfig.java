package com.ai.Generator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Allow CORS
public class WebConfig implements WebMvcConfigurer {

  @Value("${app.accepted.host}")
  private String acceptedHost;

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins(acceptedHost)
            .allowedMethods("GET")
            .allowedHeaders("*")
            .allowCredentials(true);
      }
    };
  }

}
