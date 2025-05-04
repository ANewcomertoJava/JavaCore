package zhkh.dto;


import lombok.Data;
import java.time.LocalDate;

@Data
public class UtilityMeasurementDTO {
    private Long id;
    private Long apartmentId;
    private LocalDate measurementDate;
    private double coldWater;
    private double hotWater;
    private double electricity;
}
