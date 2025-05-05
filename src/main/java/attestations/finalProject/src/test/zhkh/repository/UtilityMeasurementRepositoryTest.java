package zhkh.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import zhkh.model.Apartment;
import zhkh.model.UtilityMeasurement;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UtilityMeasurementRepositoryTest {

    @Autowired
    private UtilityMeasurementRepository measurementRepository;

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Test
    void findByApartmentIdAndDeletedFalse_ShouldReturnMeasurements() {
        // Arrange
        Apartment apartment = new Apartment();
        apartment.setAddress("ул. Тестовая, 1");
        apartmentRepository.save(apartment);

        UtilityMeasurement measurement = new UtilityMeasurement();
        measurement.setApartment(apartment);
        measurement.setMeasurementDate(LocalDate.now());
        measurementRepository.save(measurement);

        // Act
        List<UtilityMeasurement> result =
                measurementRepository.findByApartmentIdAndDeletedFalse(apartment.getId());

        // Assert
        assertEquals(1, result.size());
        assertEquals(apartment.getId(), result.get(0).getApartment().getId());
    }
    @Test
    void findByApartmentIdAndDeletedFalse_ShouldReturnFilteredData() {
        // Arrange
        Apartment apartment = new Apartment();
        apartment.setAddress("ул. Тестовая, 1");
        apartmentRepository.save(apartment);

        UtilityMeasurement active = new UtilityMeasurement();
        active.setApartment(apartment);
        active.setDeleted(false);
        measurementRepository.save(active);

        UtilityMeasurement deleted = new UtilityMeasurement();
        deleted.setApartment(apartment);
        deleted.setDeleted(true);
        measurementRepository.save(deleted);

        // Act
        List<UtilityMeasurement> result =
                measurementRepository.findByApartmentIdAndDeletedFalse(apartment.getId());

        // Assert
        assertEquals(1, result.size());
        assertFalse(result.get(0).isDeleted());
    }
}