package by.itacademy.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author i.sukach
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    public Movie(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
