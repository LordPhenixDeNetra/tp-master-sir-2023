package sn.master.sir.mastersir2023.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sn.master.sir.mastersir2023.models.Customer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerRepositoryTest {

    @Mock
    private CustomerRepository customerRepository;

    @Test
    void testFindByEmail() {
        String email = "jane@example.com";
        Customer jane = new Customer();
        jane.setId(1L);
        jane.setEmail(email);

        when(customerRepository.findByEmail(email)).thenReturn(jane);

        Customer foundCustomer = customerRepository.findByEmail(email);

        assertEquals(jane, foundCustomer);
        verify(customerRepository, times(1)).findByEmail(email);
    }

    @Test
    void testFindAll() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1L, "John"));
        customers.add(new Customer(2L, "Jane"));

        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> foundCustomers = customerRepository.findAll();

        assertEquals(customers, foundCustomers);
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void testSave() {
        Customer newCustomer = new Customer(3L, "Alice");

        when(customerRepository.save(newCustomer)).thenReturn(newCustomer);

        Customer savedCustomer = customerRepository.save(newCustomer);

        assertEquals(newCustomer, savedCustomer);
        verify(customerRepository, times(1)).save(newCustomer);
    }

}
