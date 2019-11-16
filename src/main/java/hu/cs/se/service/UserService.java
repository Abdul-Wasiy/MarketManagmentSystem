package hu.cs.se.service;

import hu.cs.se.model.Customer;
import hu.cs.se.model.User;

public interface UserService {
    void saveUser(User user);
    Object findAll();

    User findUserById(Long id);

    void deleteUserById(Long id);

    void createUser(User user);
}
