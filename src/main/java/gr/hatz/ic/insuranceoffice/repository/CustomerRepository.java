package gr.hatz.ic.insuranceoffice.repository;

import gr.hatz.ic.insuranceoffice.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByLastNameStartingWith(String lastName);
    Customer findCustomerById(Long id);
}
