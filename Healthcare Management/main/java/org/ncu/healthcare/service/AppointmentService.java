package org.ncu.healthcare.service;

import java.util.List;

import org.ncu.healthcare.entity.Appointment;

public interface AppointmentService {
    Appointment getAppointmentById(int appointmentId);
    Appointment saveOrUpdateAppointment(Appointment appointment);
    void deleteAppointment(int appointmentId);
    List<Appointment> getAllAppointments();
}
