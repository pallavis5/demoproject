package com.cognizant.smartshopservice;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.smartshopservice.controller.ProductController;
import com.cognizant.smartshopservice.model.Product;
import com.cognizant.smartshopservice.repository.ProductRepository;
import com.cognizant.smartshopservice.service.ProductService;


@FixMethodOrder
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SmartShopServiceApplicationTests {
	
	@Autowired
	ProductRepository productrepository;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductController productController;
	
	@Autowired
	private MockMvc mvc;
	
	/*void contextLoads(){
		
	}*/
	
	@Test
    public void testProductList(){
                    List<Product> products = productrepository.productList("Electronics");
                    assertEquals(products.isEmpty(), false);               
    }
	
	@Test
	public void testDeleteProduct(){
		productService.deleteProduct("13");
		Product product=productService.getOne("13");
		assertNotNull(product);	
	}
	
	@Test
	public void testProductAll() throws Exception{
		ResultActions actions=mvc.perform(get("/product"));
		actions.andExpect(status().isOk());
		
	}
	@Test
	public void testGetBill() throws Exception{
		ResultActions actions=mvc.perform(get("/product/bill/pallavi"));
		actions.andExpect(status().isBadRequest());
		
	}


}
