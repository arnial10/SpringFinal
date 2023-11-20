package com.example.demo;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the productsshoprelation database table.
 * 
 */
@Entity(name = "Productsshoprelations")
@NamedQuery(name="Productsshoprelations.findAll", query="SELECT p FROM Productsshoprelations p")
public class Productsshoprelations implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_Relationship;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Products product;

	//bi-directional many-to-one association to Shop
	@ManyToOne
	@JoinColumn(name="shop_id")
	private Shops shop;

	public Productsshoprelations() {
	}

	public int getId_Relationship() {
		return this.id_Relationship;
	}

	public void setId_Relationship(int id_Relationship) {
		this.id_Relationship = id_Relationship;
	}

	public Products getProduct() {
		return this.product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Shops getShop() {
		return this.shop;
	}

	public void setShop(Shops shop) {
		this.shop = shop;
	}

}