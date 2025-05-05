package zhkh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zhkh.model.UtilityMeasurement;

import java.util.List;

public interface UtilityMeasurementRepository extends JpaRepository<UtilityMeasurement, Long> {
    List<UtilityMeasurement> findByDeletedFalse();
    List<UtilityMeasurement> findByApartmentIdAndDeletedFalse(Long apartmentId);
}
