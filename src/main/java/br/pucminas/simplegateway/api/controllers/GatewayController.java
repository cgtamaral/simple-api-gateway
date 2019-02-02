package br.pucminas.simplegateway.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GatewayController 
{
	
	Logger logger = LoggerFactory.getLogger(GatewayController.class);
	
	@Value("${consultagooglebooks.service.host}")
	private String consultaGoogleBooksHost;
	
	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
	    return builder.routes()
	        .route(p -> p.path("/v1/public/books").uri(consultaGoogleBooksHost))
	        .build();
	}
}
