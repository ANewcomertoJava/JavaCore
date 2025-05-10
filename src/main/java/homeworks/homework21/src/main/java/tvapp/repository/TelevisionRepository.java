package tvapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tvapp.entity.Television;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
}
