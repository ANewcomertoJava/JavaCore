package zhkh.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import zhkh.dto.UtilityMeasurementDTO;
import zhkh.service.UtilityMeasurementService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/measurements")
@Tag(name = "Показания коммунальных услуг", description = "Операции с показаниями")
public class UtilityMeasurementController {

    private final UtilityMeasurementService measurementService;

    public UtilityMeasurementController(UtilityMeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @Operation(summary = "Получить все показания")
    @GetMapping
    public List<UtilityMeasurementDTO> getAllMeasurements() {
        return measurementService.findAll();
    }

    @Operation(summary = "Получить показания по квартире")
    @GetMapping("/apartment/{apartmentId}")
    public List<UtilityMeasurementDTO> getMeasurementsByApartment(
            @Parameter(description = "ID квартиры") @PathVariable Long apartmentId) {
        return measurementService.findByApartmentId(apartmentId);
    }

    @Operation(summary = "Добавить новые показания")
    @PostMapping
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Данные показаний коммунальных услуг",
            required = true,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            name = "Пример запроса",
                            value = """
                {
                    "apartmentId": 1,
                    "measurementDate": "2023-05-15",
                    "coldWater": 10.5,
                    "hotWater": 7.3,
                    "electricity": 125.8
                }
                """
                    )
            )
    )
    public UtilityMeasurementDTO createMeasurement(
            @RequestBody @Valid UtilityMeasurementDTO measurementDTO) {
        return measurementService.save(measurementDTO);
    }

    @Operation(summary = "Удалить показания")
    @DeleteMapping("/{id}")
    public void deleteMeasurement(@Parameter(description = "ID показаний") @PathVariable Long id) {
        measurementService.delete(id);
    }
}