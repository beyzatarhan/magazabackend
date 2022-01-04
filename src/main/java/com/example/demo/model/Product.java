package com.example.demo.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int barkod;
	

	@JsonIgnore
	@OneToMany(mappedBy = "product")
	Set<Sayim> sayimlar = new HashSet<>();
	
	@Column(name = "stockCode")
	private int stockCode;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "reyon")
	private String reyon;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "koli")
	private int koli;
	
	public Product() {
		
	}
	public Product(int barkod, int stockCode, String name, String reyon, float price, int koli) {
		super();
		this.barkod = barkod;
		this.stockCode = stockCode;
		this.name = name;
		this.reyon = reyon;
		this.price = price;
		this.koli = koli;
	}
	public long getBarkod() {
		return barkod;
	}
	public void setBarkod(int barkod) {
		this.barkod = barkod;
	}
	public long getStockCode() {
		return stockCode;
	}
	public void setStockCode(int stockCode) {
		this.stockCode = stockCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReyon() {
		return reyon;
	}
	public void setReyon(String reyon) {
		this.reyon = reyon;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getKoli() {
		return koli;
	}
	public void setKoli(int koli) {
		this.koli = koli;
	}
	
	public Set<Sayim> getSayimlar() {
		return sayimlar;
	}
	
	
	
	
}

