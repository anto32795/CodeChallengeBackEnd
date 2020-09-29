package com.codechallenge2.models;

import java.time.LocalDateTime;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
    private String email;
    
	@Column(name = "birthday")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime birthDate;
    
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "adress", referencedColumnName = "id")
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
	public User() {
	}
	public User(Integer id, String name, String email, LocalDateTime birthDate, Adress adress) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.adress = adress;
	}
}