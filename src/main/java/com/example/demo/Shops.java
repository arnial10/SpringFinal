package com.example.demo;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the shops database table.
 * 
 */
@Entity(name = "Shops")
@Table(name="shops")
@NamedQuery(name="Shops.findAll", query="SELECT s FROM Shops s")
public class Shops implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_Shops;

	private BigDecimal latitude;

	private BigDecimal longitude;

	private String name;

	//bi-directional many-to-one association to Productsshoprelation
	@OneToMany(mappedBy="shop")
	private List<Productsshoprelations> productsshoprelations;

	public Shops() {
	}

	public int getId_Shops() {
		return this.id_Shops;
	}

	public void setId_Shops(int id_Shops) {
		this.id_Shops = id_Shops;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Productsshoprelations> getProductsshoprelations() {
		return this.productsshoprelations;
	}

	public void setProductsshoprelations(List<Productsshoprelations> productsshoprelations) {
		this.productsshoprelations = productsshoprelations;
	}

	public Productsshoprelations addProductsshoprelation(Productsshoprelations productsshoprelation) {
		getProductsshoprelations().add(productsshoprelation);
		productsshoprelation.setShop(this);

		return productsshoprelation;
	}

	public Productsshoprelations removeProductsshoprelation(Productsshoprelations productsshoprelation) {
		getProductsshoprelations().remove(productsshoprelation);
		productsshoprelation.setShop(null);

		return productsshoprelation;
	}

}