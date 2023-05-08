package gr.hatz.ic.insuranceoffice.service;

import gr.hatz.ic.insuranceoffice.Model.Appointment;
import gr.hatz.ic.insuranceoffice.dto.AppointmentDTO;
import gr.hatz.ic.insuranceoffice.dto.InsuranceAgentDTO;
import gr.hatz.ic.insuranceoffice.Model.InsuranceAgent;
import gr.hatz.ic.insuranceoffice.service.exceptions.EntityNotFoundException;

import java.util.List;

public interface IInsuranceAgentService {
    InsuranceAgent insertInsuranceAgent(InsuranceAgentDTO insuranceAgentDTO);
    InsuranceAgent updateInsuranceAgent(InsuranceAgentDTO insuranceAgentDTO) throws EntityNotFoundException;
    void deleteInsuranceAgent(Long id) throws EntityNotFoundException;
    List<InsuranceAgent> getInsuranceAgentsByLastname(String lastname) throws EntityNotFoundException;
    InsuranceAgent getInsuranceAgentById(Long id) throws EntityNotFoundException;
    List<Appointment> getAppointmentsForInsuranceAgent(Long insuranceAgentId) throws EntityNotFoundException;
    Appointment addAppointmentForInsuranceAgent(Long insuranceAgentId, AppointmentDTO appointmentDTO) throws EntityNotFoundException;
    Appointment updateAppointmentForInsuranceAgent(Long insuranceAgentId, AppointmentDTO appointmentDTO) throws EntityNotFoundException;
    void deleteAppointmentForInsuranceAgent(Long insuranceAgentId, Long appointmentId) throws EntityNotFoundException;
}