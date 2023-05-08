package gr.hatz.ic.insuranceoffice.repository;

import gr.hatz.ic.insuranceoffice.Model.InsuranceAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceAgentRepository extends JpaRepository<InsuranceAgent, Long> {
    List<InsuranceAgent> findByLastNameStartingWith(String lastName);
    InsuranceAgent findInsuranceAgentById(Long id);
}
