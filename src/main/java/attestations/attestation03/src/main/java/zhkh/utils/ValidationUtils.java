package zhkh.utils;

import zhkh.dto.ApartmentDTO;
import zhkh.dto.UtilityMeasurementDTO;
import org.springframework.util.StringUtils;

public class ValidationUtils {

    public static void validateApartment(ApartmentDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("ApartmentDTO cannot be null");
        }
        if (!StringUtils.hasText(dto.getAddress())) {
            throw new IllegalArgumentException("Address is required");
        }
        if (dto.getApartmentNumber() <= 0) {
            throw new IllegalArgumentException("Apartment number must be positive");
        }
    }

    public static void validateMeasurement(UtilityMeasurementDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("UtilityMeasurementDTO cannot be null");
        }
        if (dto.getApartmentId() == null) {
            throw new IllegalArgumentException("Apartment ID is required");
        }
        if (dto.getColdWater() < 0 || dto.getHotWater() < 0 || dto.getElectricity() < 0) {
            throw new IllegalArgumentException("Utility values cannot be negative");
        }
    }
}