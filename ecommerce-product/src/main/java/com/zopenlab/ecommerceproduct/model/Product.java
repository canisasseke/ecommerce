package com.zopenlab.ecommerceproduct.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Entity
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "The title must not be null and must contain at least one non-whitespace character.")
	@NotEmpty(message = "The title must not be null nor empty. ")
	private String titre;
	
	@NotBlank(message = "The description must not be null and must contain at least one non-whitespace character.")
	@NotEmpty(message = "The description must not be null nor empty. ")
	private String description;
	
	private String image;
	
	@Positive(message = "The price must be a strictly positive number")
	private Double prix;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String titre, String description, String image, Double prix) {
		super();
		this.titre = titre;
		this.description = description;
		this.image = image;
		this.prix = prix;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", titre=" + titre + ", description=" + description + ", image=" + image
				+ ", prix=" + prix + "]";
	}

	
	
}
