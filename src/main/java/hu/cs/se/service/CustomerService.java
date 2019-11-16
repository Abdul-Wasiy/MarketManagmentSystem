package hu.cs.se.service;

import hu.cs.se.model.Customer;

public interface CustomerService {
    void saveCustomer(Customer customer);
    Object findAll();

    Customer findCustomerById(Long id);

    void deleteCustomerById(Long id);
}
