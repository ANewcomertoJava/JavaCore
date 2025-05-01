package tvapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tvapp.entity.Television;
import tvapp.repository.TelevisionRepository;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/televisions")
public class TelevisionController {

    @Autowired
    private TelevisionRepository televisionRepository;

    @GetMapping
    public List<Television> getAllTelevisions() {
        log.info("Received request to get all televisions");
        return televisionRepository.findAll();
    }

    @PostMapping
    public Television createTelevision(@RequestBody Television television) {
        log.info("Received request to create television: {}", television);
        return televisionRepository.save(television);
    }

    @GetMapping("/{id}")
    public Television getTelevisionById(@PathVariable Long id) {
        log.info("Received request to get television with id: {}", id);
        return televisionRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Television updateTelevision(@PathVariable Long id, @RequestBody Television televisionDetails) {
        log.info("Received request to update television with id: {}", id);
        Television television = televisionRepository.findById(id).orElseThrow();
        log.debug("Updating television from: {} to: {}", television, televisionDetails);
        television.setBrand(televisionDetails.getBrand());
        television.setModel(televisionDetails.getModel());
        television.setPrice(televisionDetails.getPrice());
        television.setScreenSize(televisionDetails.getScreenSize());
        return televisionRepository.save(television);
    }

    @DeleteMapping("/{id}")
    public void deleteTelevision(@PathVariable Long id) {
        log.info("Received request to delete television with id: {}", id);
        televisionRepository.deleteById(id);
    }


}