package org.edindandil.restapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "sensor")
@NoArgsConstructor
public class Sensor {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Название сенсора не должно быть пустым!")
    @Size(min = 3, max = 30, message = "Название сенсора должно содержать от 3 до 30 символов")
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "sensor")
    private List<Measurement> measurements;

    public @NotEmpty(message = "Название сенсора не должно быть пустым!") @Size(min = 3, max = 30, message = "Название сенсора должно содержать от 3 до 30 символов") String getName() {
        return name;
    }
    public void setName(@NotEmpty(message = "Название сенсора не должно быть пустым!") @Size(min = 3, max = 30, message = "Название сенсора должно содержать от 3 до 30 символов") String name) {
        this.name = name;
    }
}