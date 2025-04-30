package zhkh.service;

import org.springframework.stereotype.Service;
import zhkh.dto.ApartmentDTO;
import zhkh.model.Apartment;
import zhkh.repository.ApartmentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;

    public ApartmentService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    public List<ApartmentDTO> findAll() {
        return apartmentRepository.findByDeletedFalse().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ApartmentDTO save(ApartmentDTO apartmentDTO) {
        Apartment apartment = convertToEntity(apartmentDTO);
        Apartment saved = apartmentRepository.save(apartment);
        return convertToDTO(saved);
    }

    public void delete(Long id) {
        apartmentRepository.findById(id).ifPresent(apartment -> {
            apartment.setDeleted(true);
            apartmentRepository.save(apartment);
        });
    }

    private ApartmentDTO convertToDTO(Apartment apartment) {
        ApartmentDTO dto = new ApartmentDTO();
        dto.setId(apartment.getId());
        dto.setAddress(apartment.getAddress());
        dto.setApartmentNumber(apartment.getApartmentNumber());
        dto.setArea(apartment.getArea());
        return dto;
    }

    private Apartment convertToEntity(ApartmentDTO dto) {
        Apartment apartment = new Apartment();
        apartment.setId(dto.getId());
        apartment.setAddress(dto.getAddress());
        apartment.setApartmentNumber(dto.getApartmentNumber());
        apartment.setArea(dto.getArea());
        return apartment;
    }
}
