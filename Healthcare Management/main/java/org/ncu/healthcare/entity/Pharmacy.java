package org.ncu.healthcare.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pharmacy_table")
public class Pharmacy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pharmacyId; 
	@Column(length = 255 , nullable = false)
	private String pharmacyName;
	@Column(length = 255 , nullable = false)
	private String location;
	
	@OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL )
	@JsonIgnore
	private List<Inventory> inventories;
	@JsonIgnore
	@OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL )
	private List<Delivery> deliveries;
	
	public Pharmacy(int pharmacyId, String pharmacyName, String location, List<Inventory> inventories,
			List<Delivery> deliveries) {
		super();
		this.pharmacyId = pharmacyId;
		this.pharmacyName = pharmacyName;
		this.location = location;
		this.inventories = inventories;
		this.deliveries = deliveries;
	}

	public Pharmacy() {
		super();
	}

	@Override
	public String toString() {
		return "Pharmacy [pharmacyId=" + pharmacyId + ", pharmacyName=" + pharmacyName + ", location=" + location
				+ ", inventories=" + inventories + "]";
	}

	public int getPharmacyId() {
		return pharmacyId;
	}

	public void setPharmacyId(int pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

	public String getPharmacyName() {
		return pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Inventory> getInventories() {
		return inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}

	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	} 
	
	
	

}
