package tvapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tvapp.entity.Television;
import tvapp.repository.TelevisionRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public List<Television> getAllTelevisions() {
        log.info("Fetching all televisions");
        List<Television> televisions = televisionRepository.findAll();
        log.debug("Found {} televisions", televisions.size());
        return televisions;
    }

    public Optional<Television> getTelevisionById(Long id) {
        log.info("Fetching television with id: {}", id);
        Optional<Television> television = televisionRepository.findById(id);
        television.ifPresentOrElse(
                tv -> log.debug("Found television: {}", tv),
                () -> log.warn("Television with id {} not found", id)
        );
        return television;
    }

    @Transactional
    public Television createTelevision(Television television) {
        log.info("Creating new television: {}", television);
        Television savedTelevision = televisionRepository.save(television);
        log.info("Created television with id: {}", savedTelevision.getId());
        return savedTelevision;
    }

    @Transactional
    public Television updateTelevision(Long id, Television televisionDetails) {
        log.info("Updating television with id: {}", id);
        Television television = televisionRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Television not found with id: {}", id);
                    return new RuntimeException("Television not found with id: " + id);
                });

        log.debug("Updating television from: {}", television);
        television.setBrand(televisionDetails.getBrand());
        television.setModel(televisionDetails.getModel());
        television.setPrice(televisionDetails.getPrice());
        television.setScreenSize(televisionDetails.getScreenSize());

        Television updatedTelevision = televisionRepository.save(television);
        log.debug("Updated television to: {}", updatedTelevision);
        return updatedTelevision;
    }

    @Transactional
    public void deleteTelevision(Long id) {
        log.info("Deleting television with id: {}", id);
        Television television = televisionRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Television not found with id: {}", id);
                    return new RuntimeException("Television not found with id: " + id);
                });

        televisionRepository.delete(television);
        log.info("Deleted television with id: {}", id);
    }
}