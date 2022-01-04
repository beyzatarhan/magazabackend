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
@Table(name = "employee")
public class Employee{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	Set<Sayim> sayimlar = new HashSet<>();
	
	@Column(name = "tc")
	private String tc;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "unvan")
	private String unvan;
	
	@Column(name = "sayim")
	private int sayim;
	
	@Column(name = "password")
	private String password;
	
	public Employee(int id, String tc, String name, String unvan, int sayim, String password) {
		super();
		this.id = id;
		this.tc = tc;
		this.name = name;
		this.unvan = unvan;
		this.sayim = sayim;
		this.password = password;
	}
	
	public Set<Sayim> getSayimlar() {
		return sayimlar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnvan() {
		return unvan;
	}

	public void setUnvan(String unvan) {
		this.unvan = unvan;
	}

	public int getSayim() {
		return sayim;
	}

	public void setSayim(int sayim) {
		this.sayim = sayim;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSayimlar(Set<Sayim> sayimlar) {
		this.sayimlar = sayimlar;
	}

	
}
