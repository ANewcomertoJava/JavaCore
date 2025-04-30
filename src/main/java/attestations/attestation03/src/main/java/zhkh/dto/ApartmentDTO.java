package zhkh.dto;


import lombok.Data;

@Data
public class ApartmentDTO {
    private Long id;
    private String address;
    private int apartmentNumber;
    private double area;
}
