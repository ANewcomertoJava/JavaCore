package jpademo.model;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Orders {
    private Long id;
    private Long userId;
    private Date orderDate;
    private Long totalNumberOf;
    private Long buyerDiscount;
}