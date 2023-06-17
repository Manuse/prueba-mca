package com.pruebamca.products.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.pruebamca.products.rest.clients.SimulateClient;

@Configuration
public class BeansConfig {

	@Bean
	SimulateClient simulateClientBean(@Value("${simulate.rest.url}") String baseUrl) {
		return HttpServiceProxyFactory
				.builder(WebClientAdapter
						.forClient(WebClient.builder()
								.baseUrl(baseUrl)
								.build()))
				.build()
				.createClient(SimulateClient.class);
	}
	
}
