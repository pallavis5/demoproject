package com.cognizant.smartshopservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.smartshopservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	@Query(value = "select distinct pro.proType from Product pro")
	List<String> productTypeList();

	@Query(value = "from Product product where product.proType=?1")
	List<Product> productList(String type);

	@Query(value = "from Product pro")
	List<Product> productAll();

	@Query(value = "from Product product where product.proCode=?1")
	Product getOne(String code);


}
