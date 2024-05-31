package org.ncu.healthcare.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medication_table")
public class Medication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int medicationId; 
	@Column(length = 255 , nullable = false)
	private String medicationName;
	@Column(length = 255 , nullable = false)
	private int stockLeve;
	
	public Medication(int medicationId, String medicationName, int stockLeve) {
		super();
		this.medicationId = medicationId;
		this.medicationName = medicationName;
		this.stockLeve = stockLeve;
	}

	public Medication() {
		super();
	}

	@Override
	public String toString() {
		return "Medication [medicationId=" + medicationId + ", medicationName=" + medicationName + ", stockLeve="
				+ stockLeve + "]";
	}

	public int getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(int medicationId) {
		this.medicationId = medicationId;
	}

	public String getMedicationName() {
		return medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	public int getStockLeve() {
		return stockLeve;
	}

	public void setStockLeve(int stockLeve) {
		this.stockLeve = stockLeve;
	}
	
	
	
	

}
