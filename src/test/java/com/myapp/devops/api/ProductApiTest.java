package com.myapp.devops.api;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.devops.dto.ProductDto;
import com.myapp.devops.model.Product;
import com.myapp.devops.service.ProductService;

@SpringBootTest

@AutoConfigureMockMvc(addFilters = false)
public class ProductApiTest {
	
	@MockBean
	private ProductService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("Test Product by Id - GET /api/v1/products/")
	public void testGetProductsById() throws Exception {
		
		// Prepare Mock Product
		ProductDto product = new ProductDto("Oneplus", 70000.00, 4.5);
		product.setId(1);
		
		// Prepare Mock Service Method
		
		doReturn(Optional.of(product)).when(service).getProductById(product.getId());
		
		// Perform GET Request
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products/{id}",1))
		// Validate Status should be 200 OK and JSON response received
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		
		// Validate Response Body
		
		
		// {"productId":1,
		
		// "productName":"Oneplus",
		
		// "description":"",
		
		// "price":70000,
		
		// "starRating":4.5}
		
		.andExpect(jsonPath("$.id", is(1)))
		.andExpect(jsonPath("$.productName", is("Oneplus")))
		
		.andExpect(jsonPath("$.price", is(70000.00)))
		.andExpect(jsonPath("$.rating", is(4.5)));
		
		
	}
	
	@Test
	@DisplayName("Test All Products /api/v1/products/")
	public void testGetAllProducts() throws Exception {
		
		// Prepare Mock Product
		ProductDto product1 = new ProductDto("Oneplus", 70000.00, 4.5);
		product1.setId(35);
		
		ProductDto product2 = new ProductDto("Oneplus", 60000.00, 4.5);
		product2.setId(36);
		
		List<ProductDto> products = new ArrayList<>();
		products.add(product1);
		products.add(product2);
		
		// Prepare Mock Service Method
		
		doReturn(products).when(service).listProducts();
		
		// Perform GET Request
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products"))
		// Validate Status should be 200 OK and JSON response received
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		
		// Validate Response Body
		
		.andExpect(jsonPath("$[0].id", is(35)))
		.andExpect(jsonPath("$[0].productName", is("Oneplus")))
		
		.andExpect(jsonPath("$[0].price", is(70000.00)))
		.andExpect(jsonPath("$[0].rating", is(4.5)))
		
		.andExpect(jsonPath("$[1].id", is(36)))
		.andExpect(jsonPath("$[1].productName", is("Oneplus")))
		
		.andExpect(jsonPath("$[1].price", is(60000.00)))
		.andExpect(jsonPath("$[1].rating", is(4.5)));
		
		
		
		
	}
	
	
	
	
	
	
	
	@Test
	@DisplayName("Test Add New Product")
	public void testAddNewProduct() throws Exception {
		
		// Prepare Mock Product
		ProductDto newproduct = new ProductDto("Oneplus",70000.00, 4.5);
		
		ProductDto mockproduct = new ProductDto("Oneplus", 70000.00, 4.5);
		mockproduct.setId(50);
		// Prepare Mock Service Method
		
		doReturn(mockproduct).when(service).addProduct(ArgumentMatchers.any());
		
		// Perform GET Request
		
		mockMvc.perform(post("/api/v1/products")
		// Validate Status should be 200 OK and JSON response received
		
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.content(new ObjectMapper().writeValueAsString(newproduct)))
		
		
		// Validate Response Body
		.andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.id", is(50)))
		.andExpect(jsonPath("$.productName", is("Oneplus")))
		
		.andExpect(jsonPath("$.price", is(70000.00)))
		.andExpect(jsonPath("$.rating", is(4.5)));
		
		
	}
	//@Test
	@DisplayName("Test Update Existing Product")
	public void testUpdateExistingProduct() throws Exception {
		
		// Prepare Mock Product
		
		ProductDto mockproduct = new ProductDto("Oneplus", 70000.00, 4.5);
		
		ProductDto productToBeUpdated = new ProductDto("Oneplus",70000.00, 4.5);
		productToBeUpdated.setId(50);
		
		
		mockproduct.setId(50);
		// Prepare Mock Service Method
		
		doReturn(Optional.of(mockproduct)).when(service).getProductById(50);
		
		doReturn(mockproduct).when(service).addProduct(ArgumentMatchers.any());
		
		// Perform GET Request
		
		mockMvc.perform(put("/api/v1/products/{id}",50)
		// Validate Status should be 200 OK and JSON response received
		
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.content(new ObjectMapper().writeValueAsString(productToBeUpdated)))
		
		
		// Validate Response Body
		.andExpect(status().isOk())
		//.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.id", is(50)))
		.andExpect(jsonPath("$.productName", is("Oneplus")))
		
		.andExpect(jsonPath("$.price", is(70000.00)))
		.andExpect(jsonPath("$.rating", is(4.5)));
		
		
	}
	

}