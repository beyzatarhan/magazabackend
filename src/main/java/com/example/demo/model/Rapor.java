package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="rapor")
public class Rapor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rapor_id;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sayim_id", referencedColumnName = "id")
    private Sayim sayim;

	public int getRapor_id() {
		return rapor_id;
	}

	public void setRapor_id(int rapor_id) {
		this.rapor_id = rapor_id;
	}

	public Sayim getSayim() {
		return sayim;
	}

	public void setSayim(Sayim sayim) {
		this.sayim = sayim;
	}
	
	
}
