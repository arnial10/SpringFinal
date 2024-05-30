package com.example.demo;
 
import java.io.Serializable;
import java.math.BigDecimal;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
 
 
/**
* The persistent class for the users database table.
* 
*/
@Entity(name = "Users")
@Table(name="users")
@NamedQuery(name="Users.findAll", query="SELECT u FROM Users u")
public class Users implements Serializable {
    @Override
	public String toString() {
		return "Users [id_Users=" + id_Users + ", email=" + email + ", name=" + name + ", password=" + password
				+ ", surname=" + surname + ", admin=" + admin + ", baja=" + baja + "]";
	}

	private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Users;
    private String email;
 
    private String name;
 
    private String password;
 
    private String surname;
    private boolean admin = false;
    private boolean baja;
 
    public boolean getAdmin() {
		return admin;
	}
 
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
 
	public boolean getBaja() {
		return baja;
	}
 
	public void setBaja(boolean baja) {
		this.baja = baja;
	}
 
	public Users() {
    }
    public int getId_Users() {
		return id_Users;
	}
 
	public void setId_Users(int id_Users) {
		this.id_Users = id_Users;
	}
 
	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
 
	public String getSurname() {
		return surname;
	}
 
	public void setSurname(String surname) {
		this.surname = surname;
	}
 
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
 
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
 
}