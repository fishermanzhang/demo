package com.zhq.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lenovo on 2015/11/5.
 * @author 张洪强
 */
@Entity
@Table(name="SpringMVC_User")
public class User {
	private Long userId;
	private String username;
	private String password;

	/**
	 * 空参构造
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 有参构造
	 * @param userId
	 * @param username
	 * @param password
	 */
	public User(Long userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	@Id
	@GeneratedValue
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}
	
}
