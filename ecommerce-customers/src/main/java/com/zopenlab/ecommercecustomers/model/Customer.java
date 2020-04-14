package com.zopenlab.ecommercecustomers.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  id;
	
	@NotBlank(message = "le nom doit contenir au moins un caractere different de l'espace")
	@NotEmpty(message = "le nom ne peut etre vide")
	private String nom;
	
	@NotBlank(message = "le prenom doit contenir au moins un caractere different de l'espace")
	@NotEmpty(message = "le prenom doit contenir au moins un caractere different de l'espace")
	private String prenom;
	
	@Email(message = "format email obligatoire")
	private String email;
	@NotEmpty(message = "l'adresse est obligatoire")
	@NotBlank(message = "l'adresse doit contenir au moins un caractere different de l'espace\"")
	private String adresse;
	
	@Past(message = "la date doit etre avant aujourd'hui")
	private LocalDate  dateNaissance;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String nom, String prenom, String email, String adresse, LocalDate dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", adresse="
				+ adresse + ", dateNaissance=" + dateNaissance + "]";
	}
	
	
}
