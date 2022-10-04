package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Hayden Harris - CIS175 
 * DMACC FALL 2022
 * Sep 21, 2022
 */
@Entity
@Table(name="Tasks")
public class Task {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="DAY")
	private String day;
	private Boolean status;
	
	public Task() {
		super();
	}
	public Task(String name, String day, boolean stat) {
		super();
		this.name=name;
		this.day=day;
		this.status=stat;
			
	}
	
	public Task(String name, String day) {
		super();
		this.name=name;
		this.day=day;
			
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	
	public String getDay() {
		return day;
	}
	
	public void setDay(String day) {
		this.day=day;
	}
	
	public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
	

	
	
}
