package zhkh.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import zhkh.dto.ApartmentDTO;
import zhkh.service.ApartmentService;
import java.util.List;

@RestController
@RequestMapping("/api/apartments")
@Tag(name = "Управление квартирами", description = "Операции с квартирами")
public class ApartmentController {

    private final ApartmentService apartmentService;

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @Operation(summary = "Получить все квартиры")
    @GetMapping
    public List<ApartmentDTO> getAllApartments() {
        return apartmentService.findAll();
    }

    @Operation(summary = "Создать новую квартиру")
    @PostMapping
    public ApartmentDTO createApartment(@RequestBody @Schema(description = "Данные квартиры") ApartmentDTO apartmentDTO) {
        return apartmentService.save(apartmentDTO);
    }

    @Operation(summary = "Удалить квартиру")
    @DeleteMapping("/{id}")
    public void deleteApartment(@Parameter(description = "ID квартиры") @PathVariable Long id) {
        apartmentService.delete(id);
    }
}