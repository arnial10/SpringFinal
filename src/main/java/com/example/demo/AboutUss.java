package com.example.demo;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the about_us database table.
 * 
 */
@Entity(name = "About_us")
@Table(name="about_us")
@NamedQuery(name="About_us.findAll", query="SELECT a FROM About_us a")
public class AboutUss implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "description")
	private String description;

	public AboutUss() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}