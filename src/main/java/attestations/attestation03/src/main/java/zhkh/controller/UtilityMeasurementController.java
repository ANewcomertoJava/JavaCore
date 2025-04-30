package zhkh.controller;

import org.springframework.web.bind.annotation.*;
import zhkh.dto.UtilityMeasurementDTO;
import zhkh.service.UtilityMeasurementService;

import java.util.List;

@RestController
@RequestMapping("/api/measurements")
public class UtilityMeasurementController {
    private final UtilityMeasurementService measurementService;

    public UtilityMeasurementController(UtilityMeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping
    public List<UtilityMeasurementDTO> getAllMeasurements() {
        return measurementService.findAll();
    }

    @GetMapping("/apartment/{apartmentId}")
    public List<UtilityMeasurementDTO> getMeasurementsByApartment(@PathVariable Long apartmentId) {
        return measurementService.findByApartmentId(apartmentId);
    }

    @PostMapping
    public UtilityMeasurementDTO createMeasurement(@RequestBody UtilityMeasurementDTO measurementDTO) {
        return measurementService.save(measurementDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMeasurement(@PathVariable Long id) {
        measurementService.delete(id);
    }
}
