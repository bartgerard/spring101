package be.continuum.slice.repository;

import be.continuum.slice.event.ChangeCoreCustomerData;
import be.continuum.slice.model.Customer;
import be.continuum.slice.respository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ProductRepositoryTest
 *
 * @author bartgerard
 * @version v0.0.1
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void saveCustomer() {
        final Customer newCustomer = Customer.builder()
                                             .email("test")
                                             .username("test")
                                             .firstName("test")
                                             .lastName("test")
                                             .build();

        customerRepository.save(newCustomer);

        final Customer c1 = customerRepository.findOne("test");
        assertThat(c1).isEqualTo(newCustomer);
        assertThat(c1.getUsername()).isEqualTo("test");
        assertThat(c1.getFirstName()).isEqualTo("test");
        assertThat(c1.getLastName()).isEqualTo("test");

        newCustomer.handle(ChangeCoreCustomerData.builder()
                                                 .username("test1")
                                                 .firstName("test2")
                                                 .lastName("test3")
                                                 .build());
        customerRepository.save(newCustomer);

        final Customer c2 = customerRepository.findOne("test");
        assertThat(c2).isEqualTo(newCustomer);
        assertThat(c1.getUsername()).isEqualTo("test1");
        assertThat(c1.getFirstName()).isEqualTo("test2");
        assertThat(c1.getLastName()).isEqualTo("test3");
    }

}
