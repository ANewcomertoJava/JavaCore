package zhkh.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import zhkh.dto.ApartmentDTO;
import zhkh.model.Apartment;
import zhkh.repository.ApartmentRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ApartmentServiceTest {

    @Mock
    private ApartmentRepository apartmentRepository;

    @InjectMocks
    private ApartmentService apartmentService;

    @Test
    void findAll_ShouldReturnListOfApartments() {
        // Arrange
        Apartment apartment = new Apartment();
        apartment.setId(1L);
        when(apartmentRepository.findByDeletedFalse()).thenReturn(Collections.singletonList(apartment));

        // Act
        List<ApartmentDTO> result = apartmentService.findAll();

        // Assert
        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getId());
    }

    @Test
    void save_ShouldSaveAndReturnApartment() {
        // Arrange
        ApartmentDTO dto = new ApartmentDTO();
        dto.setAddress("Test Address");
        dto.setApartmentNumber(1); // Добавьте эту строку
        dto.setArea(50.0); // Опционально, если есть валидация

        Apartment savedApartment = new Apartment();
        savedApartment.setId(1L);
        savedApartment.setAddress("Test Address");
        savedApartment.setApartmentNumber(1);
        savedApartment.setArea(50.0);

        when(apartmentRepository.save(any(Apartment.class))).thenReturn(savedApartment);

        // Act
        ApartmentDTO result = apartmentService.save(dto);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Test Address", result.getAddress());
    }

    @Test
    void delete_ShouldSetDeletedFlag() {
        // Arrange
        Apartment apartment = new Apartment();
        apartment.setId(1L);
        when(apartmentRepository.findById(1L)).thenReturn(Optional.of(apartment));

        // Act
        apartmentService.delete(1L);

        // Assert
        assertTrue(apartment.isDeleted());
        verify(apartmentRepository, times(1)).save(apartment);
    }
    @Test
    void save_ShouldThrowExceptionWhenAddressIsEmpty() {
        ApartmentDTO dto = new ApartmentDTO();
        dto.setApartmentNumber(1);
        assertThrows(IllegalArgumentException.class, () -> apartmentService.save(dto));
    }


}