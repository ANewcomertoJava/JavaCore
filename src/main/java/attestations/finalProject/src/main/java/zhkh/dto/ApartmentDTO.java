package zhkh.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Объект передачи данных для квартиры")
public class ApartmentDTO {
    @Schema(description = "Уникальный идентификатор квартиры", example = "1")
    private Long id;

    @Schema(description = "Адрес дома", example = "ул. Ленина, 10", required = true)
    private String address;

    @Schema(description = "Номер квартиры", example = "25", required = true)
    private int apartmentNumber;

    @Schema(description = "Площадь квартиры (кв.м)", example = "42.5", required = true)
    private double area;
}