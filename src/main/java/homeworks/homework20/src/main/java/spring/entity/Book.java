package spring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "books")
@Data // Lombok аннотация для геттеров/сеттеров
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private int year;


}
