package org.edindandil.restapi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


public class SensorDTO {
    @NotEmpty(message = "Имя сенсора не должно быть пустым")
    @Size(min = 3, max = 30, message = "Имя сенсора должно содержать от 3 до 30 символов")
    private String name;

    public @NotEmpty(message = "Имя сенсора не должно быть пустым") @Size(min = 3, max = 30, message = "Имя сенсора должно содержать от 3 до 30 символов") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "Имя сенсора не должно быть пустым") @Size(min = 3, max = 30, message = "Имя сенсора должно содержать от 3 до 30 символов") String name) {
        this.name = name;
    }
}