package com.codechallenge2.models;

import javax.persistence.*;

@Entity
public class Adress {
    @Id
    @Column(name = "ADRESS_ID")
    private Integer id;
    
    @Column @Column(name = "STREET")
    private String street;
    
    @Column(name = "STATE")
    private String state; 
    
    @Column(name = "CITY")
    private String city;
    
    @Column(name = "COUNTRY")
    private String country;
    
    @Column(name = "ZIP")
    private String zip;
    
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Column
	private String street, state, city, country, zip;

}