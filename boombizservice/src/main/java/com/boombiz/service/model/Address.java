package com.boombiz.service.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name="address")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idaddress")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idaddress;
	private String city;
	private String country;
	private String phoneNo1;
	private String phoneNo2;
	private String postalCode;
	private String state;
	private String street;
	private Businessuser businessuser;

	public Address() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdaddress() {
		return this.idaddress;
	}

	public void setIdaddress(int idaddress) {
		this.idaddress = idaddress;
	}


	@Column(length=45)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	@Column(length=45)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	@Column(length=45)
	public String getPhoneNo1() {
		return this.phoneNo1;
	}

	public void setPhoneNo1(String phoneNo1) {
		this.phoneNo1 = phoneNo1;
	}


	@Column(length=45)
	public String getPhoneNo2() {
		return this.phoneNo2;
	}

	public void setPhoneNo2(String phoneNo2) {
		this.phoneNo2 = phoneNo2;
	}


	@Column(length=45)
	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	@Column(length=45)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Column(length=45)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}


	//bi-directional many-to-one association to Businessuser
	@ManyToOne
	@JoinColumn(name="bussinessUser")
	public Businessuser getBusinessuser() {
		return this.businessuser;
	}

	public void setBusinessuser(Businessuser businessuser) {
		this.businessuser = businessuser;
	}

}