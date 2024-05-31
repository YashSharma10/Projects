package org.ncu.healthcare.controller;

import org.ncu.healthcare.entity.Appointment;
import org.ncu.healthcare.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.saveOrUpdateAppointment(appointment);
    }

    @GetMapping("/{appointmentId}")
    public Appointment getAppointmentById(@PathVariable int appointmentId) {
        return appointmentService.getAppointmentById(appointmentId);
    }

    @PutMapping("/{appointmentId}")
    public Appointment updateAppointment(@PathVariable int appointmentId, @RequestBody Appointment appointment) {
       
        return appointmentService.saveOrUpdateAppointment(appointment);
    }

    @DeleteMapping("/{appointmentId}")
    public String deleteAppointment(@PathVariable int appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
        return "Appointment with ID " + appointmentId + " deleted successfully";
    }
}