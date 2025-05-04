package zhkh.model;
// показания счетчика


import javax.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class UtilityMeasurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    private LocalDate measurementDate;
    private double coldWater;
    private double hotWater;
    private double electricity;
    private boolean deleted = false;
}