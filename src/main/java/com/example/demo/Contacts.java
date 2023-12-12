package com.example.demo;

import java.io.Serializable;
import jakarta.persistence.*;



@Entity(name = "Contact")
@Table(name = "contact")
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contacts implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_contact")
	private String email_contact;

	private String phone_number;

	public Contacts() {
	}

	public String getEmail_contact() {
		return this.email_contact;
	}

	public void setEmail_contact(String email_contact) {
		this.email_contact = email_contact;
	}

	public String getPhone_number() {
		return this.phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

}