package zhkh.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDate;

@Data
@Schema(description = "Объект передачи данных для показаний коммунальных услуг")
public class UtilityMeasurementDTO {
    @Schema(description = "Уникальный идентификатор показаний", example = "1")
    private Long id;

    @Schema(description = "ID квартиры", example = "1", required = true)
    private Long apartmentId;

    @Schema(description = "Дата снятия показаний", example = "2023-05-15", required = true)
    private LocalDate measurementDate;

    @Schema(description = "Показания холодной воды (куб.м)", example = "10.5", required = true)
    private double coldWater;

    @Schema(description = "Показания горячей воды (куб.м)", example = "7.3", required = true)
    private double hotWater;

    @Schema(description = "Показания электроэнергии (кВт·ч)", example = "125.8", required = true)
    private double electricity;
}