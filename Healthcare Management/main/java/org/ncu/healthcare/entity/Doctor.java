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
@Table(name = "doctor_table")
public class Doctor {
	@Id
	@Column(length = 255 , nullable = false)
	 private int doctorId;
	@Column(length = 255 , nullable = false)
	
	 private String qualifications;
	@Column(length = 255 , nullable = false)
	 private String specialization;
	@Column(length = 255 , nullable = false)
	 private String contactDetails;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
	@JsonIgnore
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL )
	 private List<Appointment> appointments; // One-to-Many with Appointment
	@JsonIgnore
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL )
	 private List<Prescription> prescriptions; // One-to-Many with Prescription
	
	public Doctor(int doctorId, User user, String qualifications, String specialization, String contactDetails,
			List<Appointment> appointments, List<Prescription> prescriptions) {
		super();
		this.doctorId = doctorId;
		this.user = user;
		this.qualifications = qualifications;
		this.specialization = specialization;
		this.contactDetails = contactDetails;
		this.appointments = appointments;
		this.prescriptions = prescriptions;
	}

	public Doctor() {
		super();
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", user=" + user + ", qualifications=" + qualifications
				+ ", specialization=" + specialization + ", contactDetails=" + contactDetails + "]";
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
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
	
	
	

}
