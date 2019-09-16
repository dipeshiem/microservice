package com.training.netflixzuul;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import brave.sampler.Sampler;


@CrossOrigin
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@ComponentScan("com.training.netflixzuul")

public class NetflixZuulApplication {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(NetflixZuulApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
	 @Bean
	  public ZuulFilterSample simpleFilter() {
	     return new ZuulFilterSample();
	  }
	 
	/* @Bean
	 public CorsFilter corsFilter() {
	     final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	     final CorsConfiguration config = new CorsConfiguration();
	     config.setAllowCredentials(true);
	     config.addAllowedOrigin("*");
	     config.addAllowedHeader("*");
	     config.addAllowedMethod("OPTIONS");
	     config.addAllowedMethod("HEAD");
	     config.addAllowedMethod("GET");
	     config.addAllowedMethod("PUT");
	     config.addAllowedMethod("POST");
	     config.addAllowedMethod("DELETE");
	     config.addAllowedMethod("PATCH");
	     source.registerCorsConfiguration("/**", config);
	     return new CorsFilter(source);
	 }
	 
	 @Bean
	  public FilterRegistrationBean corsFilter1() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");
	    source.registerCorsConfiguration("/**", config);
	    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
	    bean.setOrder(0);
	    return bean;
	  }*/
	 
	 @Bean
	 public WebMvcConfigurer corsConfigurer() {
	     return new WebMvcConfigurer() {
	         public void addCorsMappings(CorsRegistry registry) {
	             registry.addMapping("/path-1/**")
	                     .allowedOrigins("http://allowed-origin.com")
	                     .allowedMethods("GET", "POST");
	         }
	     };
	 }
}

