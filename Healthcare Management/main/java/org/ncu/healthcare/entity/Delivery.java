package org.ncu.healthcare.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "delivery_table")
public class Delivery {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int deliveryId; 
	@Column(length = 255 , nullable = false)
    private String deliveryStatus;
    @Column(length = 255 , nullable = false)
    private Date deliveryDateTime;
    
    @ManyToOne
	@JoinColumn(name="pharmacyId",nullable=false)
    private Pharmacy pharmacy;
	
    @ManyToOne
	@JoinColumn(name="patientId",nullable=false)
    private Patient patient;

	public Delivery(int deliveryId, String deliveryStatus, Date deliveryDateTime, Pharmacy pharmacy, Patient patient) {
		super();
		this.deliveryId = deliveryId;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDateTime = deliveryDateTime;
		this.pharmacy = pharmacy;
		this.patient = patient;
	}

	public Delivery() {
		super();
	}

	@Override
	public String toString() {
		return "Delivery [deliveryId=" + deliveryId + ", deliveryStatus=" + deliveryStatus + ", pharmacy=" + pharmacy
				+ ", patient=" + patient + "]";
	}

	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Date getDeliveryDateTime() {
		return deliveryDateTime;
	}

	public void setDeliveryDateTime(Date deliveryDateTime) {
		this.deliveryDateTime = deliveryDateTime;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
    
    
}
