package com.codechallenge2.models;

import java.time.LocalDateTime;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class User {
    @Id
    @Column(name = "ID_USER")
	private Integer id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "EMAIL")
    private String email;
    
	@Column(name = "BIRTHDAY")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime birthDate;
    
    @OneToOne
    @JoinColumn(name = "ADRESS_ID")
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
}