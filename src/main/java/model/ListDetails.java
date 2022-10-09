package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Hayden Harris - CIS175 
 * DMACC FALL 2022
 * Oct 6, 2022
 */
@Entity
@Table(name="ListDetails")
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate tripDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private User user;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Task> listOfItems;
	
	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListDetails(int id, String listName, LocalDate tripDate, User user, List<Task> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
		this.user = user;
		this.listOfItems = listOfItems;
	}
	public ListDetails(String listName, LocalDate tripDate, User user, List<Task> listOfItems) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.user = user;
		this.listOfItems = listOfItems;
	}
	public ListDetails(String listName, LocalDate tripDate, User user) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public LocalDate getTripDate() {
		return tripDate;
	}
	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Task> getListOfItems() {
		return listOfItems;
	}
	public void setListOfItems(List<Task> listOfItems) {
		this.listOfItems = listOfItems;
	}
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", tripDate=" + tripDate + ", user=" + user
				+ ", listOfItems=" + listOfItems + "]";
	}


}


