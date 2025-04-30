package zhkh.controller;

import org.springframework.web.bind.annotation.*;
import zhkh.dto.ApartmentDTO;
import zhkh.service.ApartmentService;

import java.util.List;

@RestController
@RequestMapping("/api/apartments")
public class ApartmentController {
    private final ApartmentService apartmentService;

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping
    public List<ApartmentDTO> getAllApartments() {
        return apartmentService.findAll();
    }

    @PostMapping
    public ApartmentDTO createApartment(@RequestBody ApartmentDTO apartmentDTO) {
        return apartmentService.save(apartmentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteApartment(@PathVariable Long id) {
        apartmentService.delete(id);
    }
}
