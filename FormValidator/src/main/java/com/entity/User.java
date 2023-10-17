package com.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.formanotation.Phone;

@Entity
@Table(name = "users")
public class User {

	@Column(name = "user_name")
	@NotNull(message = "is require")
	@Size(min = 5, max = 10, message = "must be greater than or equal to five and less than equal to ten ")
	private String userName;

	@Column(name = "password")
	@NotNull(message = "is require")
	@Size(min = 5, max = 10, message = "must be greater than or equal to five and less than equal to ten ")
	private String password;
	
	@Phone(message = "{phone.invalid}")
	private String phone;

	public User(String userName, String password, String phone) {
		this.userName = userName;
		this.password = password;
		this.phone = phone;
	}

	public User() {
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
