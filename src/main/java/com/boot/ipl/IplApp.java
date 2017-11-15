package com.boot.ipl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication(scanBasePackages="com.boot.ipl")
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled=true)
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
