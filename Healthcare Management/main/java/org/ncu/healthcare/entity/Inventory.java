package org.ncu.healthcare.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory_table")
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int inventoryId; 
	@Column(length = 255 , nullable = false)
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="medicationId",nullable=false)
    private Medication medication; 
    @ManyToOne
	@JoinColumn(name="pharmacyId",nullable=false)
    private Pharmacy pharmacy;
    
	public Inventory(int inventoryId, int quantity, Medication medication, Pharmacy pharmacy) {
		super();
		this.inventoryId = inventoryId;
		this.quantity = quantity;
		this.medication = medication;
		this.pharmacy = pharmacy;
	}

	public Inventory() {
		super();
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", quantity=" + quantity + ", medication=" + medication + "]";
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Medication getMedication() {
		return medication;
	}

	public void setMedication(Medication medication) {
		this.medication = medication;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	} 
    
    
    

}
