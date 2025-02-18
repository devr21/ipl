package com.boot.ipl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication(scanBasePackages="com.boot.ipl")
public class IplApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(IplApp.class,args);
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
    		return new WebMvcConfigurerAdapter() {
    			public void addCorsMappings(CorsRegistry registry) {
    				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
    			}
    		};
    }
    
}
