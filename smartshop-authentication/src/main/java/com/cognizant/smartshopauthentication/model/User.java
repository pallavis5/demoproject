package com.cognizant.smartshopauthentication.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class User {

	@Id
	@Column(name = "user_id")
	String userId;
	@Column(name = "contact_number")
	String contact;
	@Column(name = "first_name")
	String firstname;
	@Column(name = "last_name")
	String lastname;
	@Column(name = "age")
	int age;
	@Column(name = "gender")
	String gender;
	@Column(name = "password")
	String password;
	@Column(name = "user_type")
	String userType;
	@Column(name = "status")
	String status;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_us_id"), inverseJoinColumns = @JoinColumn(name = "role_ro_id"))
	private Set<Role> roleList;

	public Set<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * @ManyToMany(fetch = FetchType.EAGER)
	 * 
	 * @JoinTable(name = "cart", joinColumns = @JoinColumn(name = "ct_us_id"),
	 * inverseJoinColumns = @JoinColumn(name = "ct_pr_id")) private
	 * Set<MenuItem> menuList;
	 * 
	 * public Set<MenuItem> getMenuList() { return menuList; }
	 * 
	 * public void setMenuList(Set<MenuItem> menuList) { this.menuList =
	 * menuList; }
	 */

}
