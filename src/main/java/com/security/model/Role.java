package com.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="authorities")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer authoriteId;
	private String authority;
	@Column(name="username")
	private String userName;
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	public Role() {
	
	}
	public Integer getAuthoriteId() {
		return authoriteId;
	}
	public void setAuthoriteId(Integer authoriteId) {
		this.authoriteId = authoriteId;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "Role [authoriteId=" + authoriteId + ", authority=" + authority + ", userName=" + userName + "]";
	}
	
	
}

