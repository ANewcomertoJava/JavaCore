package attestations.attestation03.src.main.java.zhkh.model;
// показания счетчика


import lombok.Data;
import javax.persistence.*;
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