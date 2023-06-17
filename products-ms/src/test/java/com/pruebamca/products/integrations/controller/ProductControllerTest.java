package com.pruebamca.products.integrations.controller;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.matchers.Times;
import org.mockserver.model.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	private static ClientAndServer mockServer;

    @BeforeAll
    public static void startServer() {
        mockServer = ClientAndServer.startClientAndServer(3001);
    }
    
    @AfterAll
    public static void stopServer() {
        mockServer.stop();
    }
	
	@Test
	void getProductSimilar_returnResponseEntity_whenIsAllOk() throws Exception {
		//given
		createCasesOk();
		
		//when
		//then
		mvc.perform(get("/product/1/similar"))
		.andExpect(status().isOk())
		.andExpect(content().json("""
				[{
					  "id": "1",
					  "name": "name",
					  "availability": true,
					  "price": 1.0
					}]
				"""));
		
	}
	
	@Test
	void getProductSimilar_returnResponseEntity_whenProductNotFound() throws Exception {
		//given
		createCaseNotFound();
		
		//when
		//then
		mvc.perform(get("/product/9/similar"))
		.andExpect(status().isNotFound());
		
	}
	
	@Test
	void getProductSimilar_returnResponseEntity_whenAnyErrorOcurred() throws Exception {
		//given
		//when
		//then
		mvc.perform(get("/product/ol/similar"))
		.andExpect(status().isInternalServerError());
		
	}

	private void createCasesOk() {
		MockServerClient mockServer = new MockServerClient("localhost", 3001);
        
		mockServer
        .when(request()
        		.withMethod("GET")
        		.withPath("/product/1/similarids"),
        		Times.exactly(1)
        		)
        .respond(response()
        		.withStatusCode(200)
        		.withHeaders(new Header("Content-Type", "application/json; charset=utf-8"))
                .withBody("[\"1\"]")
                .withDelay(TimeUnit.SECONDS, 1)
                );
		
		mockServer
        .when(request()
        		.withMethod("GET")
        		.withPath("/product/1"),
        		Times.exactly(1)
        		)
        .respond(response()
        		.withStatusCode(200)
        		.withHeaders(new Header("Content-Type", "application/json; charset=utf-8"))
                .withBody("""
        				{
	      				  "id": "1",
	      				  "name": "name",
	      				  "availability": "true",
	      				  "price": "1.0"
	      				}
      				""")
                .withDelay(TimeUnit.SECONDS, 1)
                );
    }
	
	private void createCaseNotFound() {
		new MockServerClient("localhost", 3001)
		.when(request()
				.withMethod("GET")
        		.withPath("/product/9/similarids"),
        		Times.exactly(1)
        		)
        .respond(response()
        		.withStatusCode(404)
                .withDelay(TimeUnit.SECONDS, 1)
                .withBody("Not Found")
                );
		
    }
	
	
}
