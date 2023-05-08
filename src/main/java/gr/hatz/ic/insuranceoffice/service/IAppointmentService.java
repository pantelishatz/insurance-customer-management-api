package gr.hatz.ic.insuranceoffice.service;

import gr.hatz.ic.insuranceoffice.dto.AppointmentDTO;
import gr.hatz.ic.insuranceoffice.Model.Appointment;
import gr.hatz.ic.insuranceoffice.service.exceptions.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

public interface IAppointmentService {
    Appointment insertAppointment(AppointmentDTO appointmentDTO);
    Appointment updateAppointment(AppointmentDTO appointmentDTO) throws EntityNotFoundException;
    void deleteAppointment(Long id) throws EntityNotFoundException;
    List<Appointment> getAppointmentsByInsuranceAgentId(Long id, LocalDateTime startDate, LocalDateTime endDate) throws EntityNotFoundException;
    Appointment getAppointmentById(Long id) throws EntityNotFoundException;
}
