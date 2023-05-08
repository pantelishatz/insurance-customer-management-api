package gr.hatz.ic.insuranceoffice.repository;

import gr.hatz.ic.insuranceoffice.Model.Appointment;
import gr.hatz.ic.insuranceoffice.Model.InsuranceAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByInsuranceAgentId(Long insuranceAgentId);

    List<Appointment> findByCustomerId(Long customerId);

    Optional<Appointment> findByIdAndInsuranceAgent(Long appointmentId, InsuranceAgent insuranceAgent);

    @Query("SELECT A FROM Appointment A WHERE A.insuranceAgent.id = ?1 AND A.appointmentDate BETWEEN ?2 AND ?3")
    List<Appointment> findAppointmentsByInsuranceAgentIdAndDateRange(Long insuranceAgentId, LocalDateTime startDate, LocalDateTime endDate);
}