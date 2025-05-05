package zhkh.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import zhkh.dto.ApartmentDTO;
import zhkh.service.ApartmentService;

import javax.validation.Valid;
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
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Данные для создания квартиры",
            required = true,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            name = "Пример запроса",
                            value = "{\"address\": \"ул. Ленина, 10\", \"apartmentNumber\": 25, \"area\": 42.5}"
                    )
            )
    )
    public ApartmentDTO createApartment(@RequestBody @Valid ApartmentDTO apartmentDTO) {
        return apartmentService.save(apartmentDTO);
    }

    @Operation(summary = "Удалить квартиру")
    @DeleteMapping("/{id}")
    public void deleteApartment(@Parameter(description = "ID квартиры") @PathVariable Long id) {
        apartmentService.delete(id);
    }
}