package gr.hatz.ic.insuranceoffice.service;

import gr.hatz.ic.insuranceoffice.dto.UserDTO;
import gr.hatz.ic.insuranceoffice.Model.User;
import gr.hatz.ic.insuranceoffice.service.exceptions.EntityNotFoundException;

public interface IUserService {
    User registerUser(UserDTO userToRegister);
    User updateUser(UserDTO userDTO) throws EntityNotFoundException;
    void deleteUser(Long id) throws EntityNotFoundException;
    User getUserByUsername(String username) throws EntityNotFoundException;
    User getUserById(Long id) throws EntityNotFoundException;
    boolean usernameAlreadyExists(String email);
}