package sn.master.sir.mastersir2023.controllers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sn.master.sir.mastersir2023.models.Customer;
import sn.master.sir.mastersir2023.services.CustomerService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class CustomerRestControllerTest {


    @Mock
    private CustomerService customerService;

    private CustomerRestController customerRestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customerRestController = new CustomerRestController(customerService);
    }

    @Test
    void testGetAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1L, "John Doe"));
        customers.add(new Customer(2L, "Jane Smith"));

        when(customerService.getAllCustomers()).thenReturn(customers);

        ResponseEntity<List<Customer>> response = customerRestController.getAllCustomers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customers, response.getBody());
    }

    @Test
    void testCreateCustomer() {
        Customer newCustomer = new Customer(3L, "Alice Johnson");

        when(customerService.createCustomer(newCustomer)).thenReturn(newCustomer);

        ResponseEntity<Customer> response = customerRestController.createCustomer(newCustomer);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(newCustomer, response.getBody());
    }

    @Test
    void testDeleteCustomer() {
        Long customerId = 1L;

        ResponseEntity<?> response = customerRestController.deleteCustomer(customerId);

        verify(customerService, times(1)).deleteCustomer(customerId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testUpdateCustomer() {
        Customer updatedCustomer = new Customer(1L, "Updated Name");

        when(customerService.updateCustomer(updatedCustomer)).thenReturn(updatedCustomer);

        ResponseEntity<Customer> response = customerRestController.updateCustomer(updatedCustomer);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedCustomer, response.getBody());
    }


}
