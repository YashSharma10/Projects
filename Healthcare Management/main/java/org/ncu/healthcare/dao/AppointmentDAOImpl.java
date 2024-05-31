package org.ncu.healthcare.dao;
import java.util.List;

import org.ncu.healthcare.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppointmentDAOImpl implements AppointmentDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public Appointment getAppointmentById(int appointmentId) {
        return entityManager.find(Appointment.class, appointmentId);
    }

    @Override
    @Transactional
    public Appointment saveOrUpdateAppointment(Appointment appointment) {
        return entityManager.merge(appointment);
    }

    @Override
    @Transactional
    public void deleteAppointment(int appointmentId) {
        Appointment appointment = entityManager.find(Appointment.class, appointmentId);
        if (appointment != null) {
            entityManager.remove(appointment);
        }
    }

    @Override
    @Transactional
    public List<Appointment> getAllAppointments() {
        return entityManager.createQuery("SELECT a FROM Appointment a", Appointment.class).getResultList();
    }
}
