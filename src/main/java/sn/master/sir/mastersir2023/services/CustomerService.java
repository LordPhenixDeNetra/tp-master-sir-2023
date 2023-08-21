package sn.master.sir.mastersir2023.services;

import org.springframework.stereotype.Service;
import sn.master.sir.mastersir2023.models.Customer;
import sn.master.sir.mastersir2023.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // create customer
    public Customer createCustomer(Customer customer) {
        // verify if customer exist
        Customer customerExist = customerRepository.findByEmail(customer.getEmail());
        if (customerExist != null) {
            throw new RuntimeException("Customer already exist");
        }
        return customerRepository.save(customer);
    }

    //delete customer
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    //update customer
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    //get customer by id
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
