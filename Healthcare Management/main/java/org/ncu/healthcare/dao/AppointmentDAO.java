package org.ncu.healthcare.dao;

import java.util.List;

import org.ncu.healthcare.entity.Appointment;

public interface AppointmentDAO {
    Appointment getAppointmentById(int appointmentId);
    Appointment saveOrUpdateAppointment(Appointment appointment);
    void deleteAppointment(int appointmentId);
    List<Appointment> getAllAppointments();
}