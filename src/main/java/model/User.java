package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Hayden Harris - CIS175 
 * DMACC FALL 2022
 * Oct 6, 2022
 */
@Entity
@Table(name="shopper")
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String userName;
	
	public User() {
		super();
	}
	public User(int id, String userName) {
		super();
		this.id=id;
		this.userName=userName;
	}
	public User(String userName) {
		super();
		this.userName=userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "User id="+id+" name=" +userName; 
	}

}
