package homeworks.homework19.src.test.java.jpademo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UsersRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testFindAll() {
        List<Customer> customers = customerRepository.findAll();
        assertThat(customers).hasSize(3);
    }

    @Test
    void testFindById() {
        Customer customer = customerRepository.findById(1L).orElse(null);
        assertThat(customer).isNotNull();
        assertThat(customer.getFirstName()).isEqualTo("Иван");
    }
}
