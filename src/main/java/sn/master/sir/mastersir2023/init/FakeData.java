package sn.master.sir.mastersir2023.init;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import sn.master.sir.mastersir2023.models.Customer;
import sn.master.sir.mastersir2023.repository.CustomerRepository;

@Component
public class FakeData implements ApplicationListener<ApplicationReadyEvent> {

    private CustomerRepository customerRepository;

    public FakeData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        Customer customer = new Customer();
        customerRepository.save(customer);

    }
}
