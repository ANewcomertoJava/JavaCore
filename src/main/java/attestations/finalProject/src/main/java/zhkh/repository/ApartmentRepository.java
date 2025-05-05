package zhkh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zhkh.model.Apartment;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    List<Apartment> findByDeletedFalse();
}
