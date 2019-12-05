package com.cognizant.smartshopservice.model;

import java.sql.Date;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "product_code")
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	String proCode;
	@Column(name = "product_name")
	String proName;
	@Column(name = "product_type")
	String proType;
	@Column(name = "brand")
	String brand;
	@Column(name = "rate")
	String rate;
	@Column(name = "stock_count")
	Integer stockCount;
	@Column(name = "add_date")
	Date addDate;
	@Column(name = "aisle")
	String aisle;
	@Column(name = "shelf")
	String shelf;
	@Column(name = "manufacture_date")
	Date manufactureDate;
	@Column(name = "expiry_date")
	Date expiryDate;
	@Column(name = "product_image")
	String image;

	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Bill> billList;

	public Set<Bill> getBillList() {
		return billList;
	}

	public void setBillList(Set<Bill> billList) {
		this.billList = billList;
	}

	public String getProCode() {
		return proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProType() {
		return proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public Integer getStockCount() {
		return stockCount;
	}

	public void setStockCount(Integer stockCount) {
		this.stockCount = stockCount;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public String getAisle() {
		return aisle;
	}

	public void setAisle(String aisle) {
		this.aisle = aisle;
	}

	public String getShelf() {
		return shelf;
	}

	public void setShelf(String shelf) {
		this.shelf = shelf;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [proCode=" + proCode + ", proName=" + proName + ", proType=" + proType + ", brand=" + brand
				+ ", rate=" + rate + ", stockCount=" + stockCount + ", addDate=" + addDate + ", aisle=" + aisle
				+ ", shelf=" + shelf + ", manufactureDate=" + manufactureDate + ", expiryDate=" + expiryDate
				+ ", image=" + image + "]";
	}

}
