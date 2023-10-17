package com.bookstore.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@Column(name = "role_id")
	private String roleId;

	@Column(name = "role_name", length = 255, nullable = false, unique = true)
	private String name;

	// to user;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
	private Set<User> users = new HashSet<User>();

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String roleId, String name) {
		super();
		this.roleId = roleId;
		this.name = name;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
