package com.pruebamca.products.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pruebamca.products.rest.clients.SimulateClient;

@ExtendWith(MockitoExtension.class)
class BeansConfigTest {

	@InjectMocks
	private BeansConfig beansConfig;
	
	@Test
	void simulateClientBean_returnSimulateClient_whenAllIsOk() {
		//given
		//when
		SimulateClient bean = beansConfig.simulateClientBean("");
		
		//then
		assertThat(bean).isNotNull();
	}
	
}
