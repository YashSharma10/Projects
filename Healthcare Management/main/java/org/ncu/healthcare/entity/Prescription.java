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
@Table(name = "prescription_table")
public class Prescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int prescriptionId;
	
	@Column(length = 255 , nullable = false)
    private String medication;
	@Column(length = 255 , nullable = false)
    private String dosage;
	@Column(length = 255 , nullable = false)
    private String instructions;
	@Column(length = 255 , nullable = false)
    private Date issueDate;
	
	@ManyToOne
	@JoinColumn(name="doctorId",nullable=false)
    private Doctor doctor;
	@ManyToOne
	@JoinColumn(name="patientId",nullable=false)
    private Patient patient;
	
	public Prescription(int prescriptionId, Doctor doctor, Patient patient, String medication, String dosage,
			String instructions, Date issueDate) {
		super();
		this.prescriptionId = prescriptionId;
		this.doctor = doctor;
		this.patient = patient;
		this.medication = medication;
		this.dosage = dosage;
		this.instructions = instructions;
		this.issueDate = issueDate;
	}

	public Prescription() {
		super();
	}

	@Override
	public String toString() {
		return "Prescription [prescriptionId=" + prescriptionId + ", doctor=" + doctor + ", patient=" + patient
				+ ", medication=" + medication + ", dosage=" + dosage + ", instructions=" + instructions
				+ ", issueDate=" + issueDate + "]";
	}

	public int getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	
	

}
