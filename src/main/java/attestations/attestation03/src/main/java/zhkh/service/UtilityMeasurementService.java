package zhkh.service;


import org.springframework.stereotype.Service;
import zhkh.dto.UtilityMeasurementDTO;
import zhkh.model.Apartment;
import zhkh.model.UtilityMeasurement;
import zhkh.repository.ApartmentRepository;
import zhkh.repository.UtilityMeasurementRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UtilityMeasurementService {
    private final UtilityMeasurementRepository measurementRepository;
    private final ApartmentRepository apartmentRepository;

    public UtilityMeasurementService(UtilityMeasurementRepository measurementRepository,
                                     ApartmentRepository apartmentRepository) {
        this.measurementRepository = measurementRepository;
        this.apartmentRepository = apartmentRepository;
    }

    public List<UtilityMeasurementDTO> findAll() {
        return measurementRepository.findByDeletedFalse().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<UtilityMeasurementDTO> findByApartmentId(Long apartmentId) {
        return measurementRepository.findByApartmentIdAndDeletedFalse(apartmentId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UtilityMeasurementDTO save(UtilityMeasurementDTO measurementDTO) {
        Optional<Apartment> apartment = apartmentRepository.findById(measurementDTO.getApartmentId());
        if (apartment.isEmpty()) {
            throw new IllegalArgumentException("Apartment not found");
        }

        UtilityMeasurement measurement = convertToEntity(measurementDTO);
        measurement.setApartment(apartment.get());
        UtilityMeasurement saved = measurementRepository.save(measurement);
        return convertToDTO(saved);
    }

    public void delete(Long id) {
        measurementRepository.findById(id).ifPresent(measurement -> {
            measurement.setDeleted(true);
            measurementRepository.save(measurement);
        });
    }

    private UtilityMeasurementDTO convertToDTO(UtilityMeasurement measurement) {
        UtilityMeasurementDTO dto = new UtilityMeasurementDTO();
        dto.setId(measurement.getId());
        dto.setApartmentId(measurement.getApartment().getId());
        dto.setMeasurementDate(measurement.getMeasurementDate());
        dto.setColdWater(measurement.getColdWater());
        dto.setHotWater(measurement.getHotWater());
        dto.setElectricity(measurement.getElectricity());
        return dto;
    }

    private UtilityMeasurement convertToEntity(UtilityMeasurementDTO dto) {
        UtilityMeasurement measurement = new UtilityMeasurement();
        measurement.setId(dto.getId());
        measurement.setMeasurementDate(dto.getMeasurementDate());
        measurement.setColdWater(dto.getColdWater());
        measurement.setHotWater(dto.getHotWater());
        measurement.setElectricity(dto.getElectricity());
        return measurement;
    }
}
