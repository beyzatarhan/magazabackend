package com.example.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "sayim")
public class Sayim {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
		
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "urun", referencedColumnName = "barkod")
	private Product product;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sayim_sahip", referencedColumnName = "id")
	private Employee employee;
		
	@Column(name = "tarih")
	private Date tarih;
	
	@Column(name = "quantity")
	private int quantity;
	
	
	
	public Sayim(int id,Date tarih, int quantity) {
		super();
		this.id = id;
		this.tarih = tarih;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getTarih() {
		return tarih;
	}
	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
}
