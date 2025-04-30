package zhkh.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import zhkh.dto.UtilityMeasurementDTO;
import zhkh.model.Apartment;
import zhkh.model.UtilityMeasurement;
import zhkh.repository.ApartmentRepository;
import zhkh.repository.UtilityMeasurementRepository;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UtilityMeasurementServiceTest {

    @Mock
    private UtilityMeasurementRepository measurementRepository;

    @Mock
    private ApartmentRepository apartmentRepository;

    @InjectMocks
    private UtilityMeasurementService measurementService;

    @Test
    void save_ShouldThrowExceptionWhenApartmentNotFound() {
        // Arrange
        UtilityMeasurementDTO dto = new UtilityMeasurementDTO();
        dto.setApartmentId(1L);
        when(apartmentRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> measurementService.save(dto));
    }

    @Test
    void findByApartmentId_ShouldReturnMeasurements() {
        // Arrange
        Apartment apartment = new Apartment();
        apartment.setId(1L);

        UtilityMeasurement measurement = new UtilityMeasurement();
        measurement.setId(1L);
        measurement.setApartment(apartment);

        when(measurementRepository.findByApartmentIdAndDeletedFalse(1L))
                .thenReturn(Collections.singletonList(measurement));

        // Act
        List<UtilityMeasurementDTO> result = measurementService.findByApartmentId(1L);

        // Assert
        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getId());
    }

    @Test
    void delete_ShouldSetDeletedFlag() {
        // Arrange
        UtilityMeasurement measurement = new UtilityMeasurement();
        measurement.setId(1L);
        when(measurementRepository.findById(1L)).thenReturn(Optional.of(measurement));

        // Act
        measurementService.delete(1L);

        // Assert
        assertTrue(measurement.isDeleted());
        verify(measurementRepository, times(1)).save(measurement);
    }

}
