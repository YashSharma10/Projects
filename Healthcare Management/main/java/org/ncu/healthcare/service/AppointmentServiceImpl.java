package org.ncu.healthcare.service;

import org.ncu.healthcare.dao.AppointmentDAO;
import org.ncu.healthcare.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentDAO appointmentDAO;

    @Override
    public Appointment getAppointmentById(int appointmentId) {
        return appointmentDAO.getAppointmentById(appointmentId);
    }

    @Override
    public Appointment saveOrUpdateAppointment(Appointment appointment) {
        return appointmentDAO.saveOrUpdateAppointment(appointment);
    }

    @Override
    public void deleteAppointment(int appointmentId) {
        appointmentDAO.deleteAppointment(appointmentId);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }
}
