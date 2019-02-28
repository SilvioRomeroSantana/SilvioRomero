package srsantana.crud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "pessoas")
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public Pessoa () {
		
	}
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Street")
	private String street;
	
	@Column(name = "Number")
	private int number;
	
	@Column(name = "Neighborhood")
	private String neighborhood;
	
	@Column(name = "City")
	private String city;
	
	@Column(name = "State")
	private String state;
	
	@Column(name = "Cellphone")
	private String cellphone;
	
	@Column(name = "Phone")
	private String phone;
	
	public String getCellphone() {
		return cellphone;
	}
	
	public String getState() {
		return state;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getNeighborhood() {
		return neighborhood;
	}
	
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	 
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name 
			+ this.neighborhood
			+ this.street
			+ this.city
			+ this.state
			+ this.cellphone
			+ this.phone;
	}
	
}

