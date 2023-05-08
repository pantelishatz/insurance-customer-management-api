package gr.hatz.ic.insuranceoffice.service;

import gr.hatz.ic.insuranceoffice.dto.CustomerDTO;
import gr.hatz.ic.insuranceoffice.Model.Customer;
import gr.hatz.ic.insuranceoffice.service.exceptions.EntityNotFoundException;

import java.util.List;

public interface ICustomerService {
    Customer insertCustomer(CustomerDTO customerDTO);
    Customer updateCustomer(CustomerDTO customerDTO) throws EntityNotFoundException;
    void deleteCustomer(Long id) throws EntityNotFoundException;
    List<Customer> getCustomersByLastname(String lastname) throws EntityNotFoundException;
    Customer getCustomerById(Long id) throws EntityNotFoundException;
}