package org.ncu.healthcare.entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient_table")
public class Patient {
	
	@Id
	private int patientId;
	
	@Column(length = 255 , nullable = false)
    private String medicalHistory;
	@Column(length = 255 , nullable = false)
    private String allergies;
	@Column(length = 255 , nullable = false)
    private String emergencyContacts;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
	@JsonIgnore
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL )
    private List<Appointment> appointments; 
	@JsonIgnore
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL )
    private List<Prescription> prescriptions; 
	@JsonIgnore
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL )
    private List<MedicalRecord> medicalRecords; 
	@JsonIgnore
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL )
    private List<Delivery> deliveries; 
	
	public Patient(int patientId, User user, String medicalHistory, String allergies, String emergencyContacts,
			List<Appointment> appointments, List<Prescription> prescriptions, List<MedicalRecord> medicalRecords,
			List<Delivery> deliveries) {
		super();
		this.patientId = patientId;
		this.user = user;
		this.medicalHistory = medicalHistory;
		this.allergies = allergies;
		this.emergencyContacts = emergencyContacts;
		this.appointments = appointments;
		this.prescriptions = prescriptions;
		this.medicalRecords = medicalRecords;
		this.deliveries = deliveries;
	}

	public Patient() {
		super();
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", user=" + user + ", medicalHistory=" + medicalHistory
				+ ", allergies=" + allergies + ", emergencyContacts=" + emergencyContacts + "]";
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getEmergencyContacts() {
		return emergencyContacts;
	}

	public void setEmergencyContacts(String emergencyContacts) {
		this.emergencyContacts = emergencyContacts;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public List<MedicalRecord> getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}
	
	
	
	

}
