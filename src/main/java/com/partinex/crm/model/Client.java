package com.partinex.crm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clients_id_seq_gen")
    @SequenceGenerator(name = "clients_id_seq_gen", sequenceName = "clients_id_seq")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="nif")
	private int nif;
	@Column(name="address")
	private String address;
	@Column(name="phone_number")
	private int phoneNumber;
	
	public Client() {
		super();
	}
	
	public Client(int id, String name, int nif, String address, int phoneNumber) {
		this.id = id;
		this.name = name;
		this.nif = nif;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNif() {
		return nif;
	}
	public void setNif(int nif) {
		this.nif = nif;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}