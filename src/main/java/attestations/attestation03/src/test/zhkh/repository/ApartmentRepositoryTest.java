package zhkh.repository;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import zhkh.model.Apartment;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ApartmentRepositoryTest {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Test
    void findByDeletedFalse_ShouldReturnOnlyNotDeleted() {
        // Arrange
        Apartment active = new Apartment();
        active.setDeleted(false);

        Apartment deleted = new Apartment();
        deleted.setDeleted(true);

        apartmentRepository.save(active);
        apartmentRepository.save(deleted);

        // Act
        List<Apartment> result = apartmentRepository.findByDeletedFalse();

        // Assert
        assertEquals(1, result.size());
        assertFalse(result.get(0).isDeleted());
    }
}
