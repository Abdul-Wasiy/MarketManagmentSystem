package hu.cs.se.service;

import hu.cs.se.model.Customer;
import hu.cs.se.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }


    @Override
    public Object findAll() {

        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public void deleteCustomerById(Long id) {
       customerRepository.deleteById(id);
    }
}
