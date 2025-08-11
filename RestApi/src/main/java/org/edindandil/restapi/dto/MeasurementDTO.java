package org.edindandil.restapi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public class MeasurementDTO {
    @NotNull(message = "Значение не может быть пустым")
    @Min(value = -100, message = "Значение не может быть меньше, чем -100")
    @Max(value = 100, message = "Значение не может быть больше, чем 100")
    private double value;

    @NotNull(message = "Значение должно быть true или false")
    private Boolean raining;

    @NotNull(message = "Должен быть указан сенсор!")
    private SensorDTO sensor;

    public @NotNull(message = "Значение не может быть пустым") @Min(value = -100, message = "Значение не может быть меньше, чем -100") @Max(value = 100, message = "Значение не может быть больше, чем 100") double getValue() {
        return value;
    }

    public void setValue(@NotNull(message = "Значение не может быть пустым") @Min(value = -100, message = "Значение не может быть меньше, чем -100") @Max(value = 100, message = "Значение не может быть больше, чем 100") double value) {
        this.value = value;
    }

    public @NotNull(message = "Значение должно быть true или false") Boolean getRaining() {
        return raining;
    }

    public void setRaining(@NotNull(message = "Значение должно быть true или false") Boolean raining) {
        this.raining = raining;
    }

    public @NotNull(message = "Должен быть указан сенсор!") SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(@NotNull(message = "Должен быть указан сенсор!") SensorDTO sensor) {
        this.sensor = sensor;
    }
}