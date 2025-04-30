package attestations.attestation03.src.main.java.zhkh.model;

// Квартира


import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private int apartmentNumber;
    private double area;
    private boolean deleted = false;
}
