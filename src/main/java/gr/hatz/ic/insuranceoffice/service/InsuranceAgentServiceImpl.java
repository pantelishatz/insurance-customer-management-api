package gr.hatz.ic.insuranceoffice.service;

import gr.hatz.ic.insuranceoffice.Model.Appointment;
import gr.hatz.ic.insuranceoffice.Model.Customer;
import gr.hatz.ic.insuranceoffice.dto.AppointmentDTO;
import gr.hatz.ic.insuranceoffice.dto.InsuranceAgentDTO;
import gr.hatz.ic.insuranceoffice.Model.InsuranceAgent;
import gr.hatz.ic.insuranceoffice.repository.AppointmentRepository;
import gr.hatz.ic.insuranceoffice.repository.InsuranceAgentRepository;
import gr.hatz.ic.insuranceoffice.service.exceptions.EntityNotFoundException;
import gr.hatz.ic.insuranceoffice.repository.CustomerRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class InsuranceAgentServiceImpl implements IInsuranceAgentService {

    private final InsuranceAgentRepository insuranceAgentRepository;
    private final AppointmentRepository appointmentRepository;

    private CustomerRepository customerRepository;

    @Autowired
    public InsuranceAgentServiceImpl(InsuranceAgentRepository insuranceAgentRepository, AppointmentRepository appointmentRepository) {
        this.insuranceAgentRepository = insuranceAgentRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Transactional
    @Override
    public InsuranceAgent insertInsuranceAgent(InsuranceAgentDTO insuranceAgentDTO) {
        return insuranceAgentRepository.save(convertToInsuranceAgent(insuranceAgentDTO));
    }

    @Transactional
    @Override
    public InsuranceAgent updateInsuranceAgent(InsuranceAgentDTO insuranceAgentDTO) throws EntityNotFoundException {
        InsuranceAgent insuranceAgent = insuranceAgentRepository.findById(insuranceAgentDTO.getId()).orElseThrow(() -> new EntityNotFoundException(InsuranceAgent.class, insuranceAgentDTO.getId()));
        return insuranceAgentRepository.save(convertToInsuranceAgent(insuranceAgentDTO));
    }

    @Transactional
    @Override
    public void deleteInsuranceAgent(Long id) throws EntityNotFoundException {
        insuranceAgentRepository.deleteById(id);
    }

    @Override
    public List<InsuranceAgent> getInsuranceAgentsByLastname(String lastname) throws EntityNotFoundException {
        List<InsuranceAgent> insuranceAgents = insuranceAgentRepository.findByLastNameStartingWith(lastname);
        if (insuranceAgents.isEmpty()) {
            throw new EntityNotFoundException(InsuranceAgent.class, 0L);
        }
        return insuranceAgents;
    }

    @Override
    public InsuranceAgent getInsuranceAgentById(Long id) throws EntityNotFoundException {
        Optional<InsuranceAgent> insuranceAgent = insuranceAgentRepository.findById(id);
        if (insuranceAgent.isEmpty()) {
            throw new EntityNotFoundException(InsuranceAgent.class, id);
        }
        return insuranceAgent.get();
    }

    @Override
    public List<Appointment> getAppointmentsForInsuranceAgent(Long InsuranceAgentId) throws EntityNotFoundException {
        InsuranceAgent insuranceAgent = getInsuranceAgentById(InsuranceAgentId);
        return appointmentRepository.findByInsuranceAgentId(InsuranceAgentId);
    }

    @Transactional
    @Override
    public Appointment addAppointmentForInsuranceAgent(Long InsuranceAgentId, AppointmentDTO appointmentDTO) throws EntityNotFoundException {
        InsuranceAgent insuranceAgent = getInsuranceAgentById(InsuranceAgentId);
        Customer customer = customerRepository.findById(appointmentDTO.getCustomerId()).orElseThrow(() -> new EntityNotFoundException(Customer.class, appointmentDTO.getCustomerId()));
        Appointment appointment = convertToAppointment(appointmentDTO, insuranceAgent, customer);
        appointment.setInsuranceAgent(insuranceAgent);
        return appointmentRepository.save(appointment);
    }

    @Transactional
    @Override
    public Appointment updateAppointmentForInsuranceAgent(Long InsuranceAgentId, AppointmentDTO appointmentDTO) throws EntityNotFoundException {
        InsuranceAgent insuranceAgent = getInsuranceAgentById(InsuranceAgentId);
        Appointment appointment = appointmentRepository.findByIdAndInsuranceAgent(appointmentDTO.getId(), insuranceAgent).orElseThrow(()
                -> new EntityNotFoundException(Appointment.class, appointmentDTO.getId()));
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        return appointmentRepository.save(appointment);
    }

    @Transactional
    @Override
    public void deleteAppointmentForInsuranceAgent(Long agentId, Long appointmentId) throws EntityNotFoundException {
        InsuranceAgent insuranceAgent = getInsuranceAgentById(agentId);
        Appointment appointment = appointmentRepository.findByIdAndInsuranceAgent(appointmentId, insuranceAgent).orElseThrow(() -> new EntityNotFoundException(Appointment.class, appointmentId));
        appointmentRepository.delete(appointment);
    }

    private static InsuranceAgent convertToInsuranceAgent(InsuranceAgentDTO dto) {
        return new InsuranceAgent(dto.getId(), dto.getFirstname(), dto.getLastname(), dto.getPhoneNumber(), dto.getInsuranceCompany(), dto.getAddress());

    }

    private static Appointment convertToAppointment(AppointmentDTO dto, InsuranceAgent insuranceAgent, Customer customer) {
        return new Appointment(dto.getId(), dto.getAppointmentDate(), insuranceAgent, customer);
    }
}
