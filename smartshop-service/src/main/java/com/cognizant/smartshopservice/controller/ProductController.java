package com.cognizant.smartshopservice.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.smartshopservice.model.Bill;
import com.cognizant.smartshopservice.model.Product;
import com.cognizant.smartshopservice.model.User;
import com.cognizant.smartshopservice.security.AppUserDetailsService;
import com.cognizant.smartshopservice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	AppUserDetailsService appUserDetailsService;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@GetMapping("/typelist")
	public List<String> productTypeList() {
		// return productService.productTypeList();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();

		LOGGER.info("User name-------" + user);
		if (user.equalsIgnoreCase("anonymousUser")) {

			// UserDetails userDetails =
			// this.appUserDetailsService.loadUserByUsername(user);
			// String role =
			// userDetails.getAuthorities().toArray()[0].toString();
			/*
			 * if (role.equals("admin")) { return
			 * movieService.getMovieListAdmin(); } if (role.equals("user")) {
			 * return movieService.getMovieListCustomer(); }
			 */
			return productService.productTypeList();
		}
		return productService.productTypeList();

	}

	@GetMapping("/{type}")
	public List<Product> productList(@PathVariable("type") String type) {
		return productService.productList(type);

	}

	@GetMapping("")
	public List<Product> productAll() {
		return productService.productAll();

	}

	@GetMapping("/edit/{code}")
	public Product getOne(@PathVariable("code") String code) {
		return productService.getOne(code);
	}

	@PutMapping("")
	public void editProduct(@RequestBody Product product) {
		productService.editProduct(product);
	}

	@PostMapping("")
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}

	@DeleteMapping("/{code}")
	public void deleteProduct(@PathVariable("code") String code) {
		productService.deleteProduct(code);
	}

	@PostMapping("/bill/{contact}/{code}/{quant}")
	public void postBill(@PathVariable("contact") String contact, @PathVariable("code") String code,
			@PathVariable("quant") int quant) {
		productService.postBill(contact, code, quant);
	}

	@GetMapping("/bill/{name}")
	public Set<Bill> getBill(@PathVariable("name") String name) {
		return productService.getBill(name);
	}

}
