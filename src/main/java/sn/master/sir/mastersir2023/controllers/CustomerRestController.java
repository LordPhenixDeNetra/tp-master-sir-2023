package sn.master.sir.mastersir2023.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.master.sir.mastersir2023.models.Customer;
import sn.master.sir.mastersir2023.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerRestController {

    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //get all customers
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok().body(customerService.getAllCustomers());
    }

    // create customer
    public ResponseEntity<Customer> createCustomer(Customer customer) {
        return ResponseEntity.ok().body(customerService.createCustomer(customer));
    }

    //delete customer
    public ResponseEntity<?> deleteCustomer(Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }

    //update customer
    public ResponseEntity<Customer> updateCustomer(Customer customer) {
        return ResponseEntity.ok().body(customerService.updateCustomer(customer));
    }

}
