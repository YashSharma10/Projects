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
@Table(name = "medicalrecord_table")
public class MedicalRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int recordId;
	@Column(length = 255, nullable = false)
    private String recordDetails;
	@Column(length = 255 , nullable = false)
    private Date dateAdded;
	
	@ManyToOne
	@JoinColumn(name="patientId",nullable=false)
    private Patient patient;
	
	
	public MedicalRecord(int recordId, Patient patient, String recordDetails, Date dateAdded) {
		super();
		this.recordId = recordId;
		this.patient = patient;
		this.recordDetails = recordDetails;
		this.dateAdded = dateAdded;
	}


	public MedicalRecord() {
		super();
	}


	@Override
	public String toString() {
		return "MedicalRecord [recordId=" + recordId + ", patient=" + patient + ", recordDetails=" + recordDetails
				+ ", dateAdded=" + dateAdded + "]";
	}


	public int getRecordId() {
		return recordId;
	}


	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public String getRecordDetails() {
		return recordDetails;
	}


	public void setRecordDetails(String recordDetails) {
		this.recordDetails = recordDetails;
	}


	public Date getDateAdded() {
		return dateAdded;
	}


	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	

}
