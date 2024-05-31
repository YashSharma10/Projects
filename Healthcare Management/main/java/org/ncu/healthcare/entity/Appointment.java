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
@Table(name = "appointment_table")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appointmentId;
	@Column(length = 255 , nullable = false)
    private Date appointmentDateTime;
	@Column(length = 255 , nullable = false)
    private String status;
	
	@ManyToOne
	@JoinColumn(name="doctorId",nullable=false)
	
    private Doctor doctor;
	@ManyToOne
	@JoinColumn(name="patientId",nullable=false)
	
    private Patient patient;
	
	
	public Appointment(int appointmentId, Doctor doctor, Patient patient, Date appointmentDateTime, String status) {
		super();
		this.appointmentId = appointmentId;
		this.doctor = doctor;
		this.patient = patient;
		this.appointmentDateTime = appointmentDateTime;
		this.status = status;
	}


	public Appointment() {
		super();
	}


	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", doctor=" + doctor + ", patient=" + patient
				+ ", appointmentDateTime=" + appointmentDateTime + ", status=" + status + "]";
	}


	public int getAppointmentId() {
		return appointmentId;
	}


	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
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


	public Date getAppointmentDateTime() {
		return appointmentDateTime;
	}


	public void setAppointmentDateTime(Date appointmentDateTime) {
		this.appointmentDateTime = appointmentDateTime;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
