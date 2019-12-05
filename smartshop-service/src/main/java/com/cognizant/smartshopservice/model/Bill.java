package com.cognizant.smartshopservice.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "bill_history")
public class Bill implements Serializable {

	@Id
	@Column(name = "bill_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int billId;

	@Column(name = "bill_date")
	Date billDate;

	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private User user;

	@ManyToOne
	@JoinColumn
	private Product product;

	@Column(name = "quantity")
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", billDate=" + billDate + ", user=" + user + ", product=" + product + "]";
	}

}
