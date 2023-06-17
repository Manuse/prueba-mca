package com.pruebamca.products.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BeansConfigTest {

	@InjectMocks
	private BeansConfig beansConfig;
	
	@Test
	void simulateClientBean_returnSimulateClient_whenAllIsOk() {
		beansConfig.simulateClientBean("");
	}
	
}
