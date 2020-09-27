package com.codechallenge2.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.*;


@Entity
public class User {
	@Id
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private LocalDateTime birthDate;
	
	@OneToOne
	private Adress adress;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adresss) {
		this.adress = adresss;
	}
	
	
	public LocalDateTime getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}
	/* Fecha de nacimiento a partir de String */
	public void setBirthDate(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
        this.birthDate = dateTime;
        
	}
	
	
}
