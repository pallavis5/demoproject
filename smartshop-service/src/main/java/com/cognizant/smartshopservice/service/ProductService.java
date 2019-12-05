package com.cognizant.smartshopservice.service;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.smartshopservice.model.Bill;
import com.cognizant.smartshopservice.model.Product;
import com.cognizant.smartshopservice.model.User;
import com.cognizant.smartshopservice.repository.ProductRepository;
import com.cognizant.smartshopservice.repository.UserRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	UserRepository userRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
	
	@Transactional
	public List<String> productTypeList() {
		return productRepository.productTypeList();
	}

	@Transactional
	public List<Product> productList(String type) {
		return productRepository.productList(type);
	}

	@Transactional
	public List<Product> productAll() {
		return productRepository.productAll();
	}

	@Transactional
	public Product getOne(String code) {
		return productRepository.getOne(code);
	}

	@Transactional
	public void editProduct(Product product) {
		productRepository.save(product);
	}

	@Transactional
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	@Transactional
	public void deleteProduct(String code) {
		productRepository.deleteById(code);
	}

	@Transactional
	public void postBill(String contact, String code, int quants) {
		Bill bill = new Bill();
		User user = userRepository.findByContact(contact);
		LOGGER.debug("user", user);
		Product pro = productRepository.findById(code).get();
		LOGGER.debug("pro", pro);
		bill.setUser(user);
		bill.setProduct(pro);
		bill.setQuantity(quants);
		bill.setBillDate(new Date(System.currentTimeMillis()));
		Set<Bill> billList = user.getBillList();
		LOGGER.debug("bill", bill);
		billList.add(bill);
		user.setBillList(billList);
		userRepository.save(user);
		pro.setStockCount(pro.getStockCount()-quants);
		productRepository.save(pro);

	}

	@Transactional
	public Set<Bill> getBill(String name) {
		// return userRepository.getBill(name);
		User user = userRepository.findByUsername(name);

		return user.getBillList();
	}

}
