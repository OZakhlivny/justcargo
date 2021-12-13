package com.olegzakhlivnyy.justcargo.entities.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.olegzakhlivnyy.justcargo.entities.Trip;
import com.olegzakhlivnyy.justcargo.utils.CustomDateDeserializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Класс Рейс.")
@JsonRootName("TripDto")
public class TripDto {
    @ApiModelProperty(notes = "Уникальный идентификатор рейса.", example = "1", required = true, position = 1)
    @JsonProperty("id")
    private Long id;

    @ApiModelProperty(notes = "Время начала рейса", required = true, position = 2)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonProperty("timestamp")
    private OffsetDateTime startTime;

    @ApiModelProperty(notes = "Время окончание рейса", required = true, position = 3)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonProperty("timestamp")
    private OffsetDateTime endTime;

    @ApiModelProperty(notes = "Пункт отправления", dataType = "String", example = "Воронеж", position = 4)
    @JsonProperty("departure")
    private String departure;

    @ApiModelProperty(notes = "Пункт назначения", dataType = "String", example = "Москва", position = 5)
    @JsonProperty("destination")
    private String destination;

    @ApiModelProperty(notes = "Идентификатор перевозчика.", example = "1", required = true, position = 6)
    @JsonProperty("carrierId")
    private Long carrierId;

    @ApiModelProperty(notes = "Идентификатор транспортного средства.", example = "1", required = true, position = 7)
    @JsonProperty("vehicleId")
    private Long vehicleId;

    @ApiModelProperty(notes = "Идентификатор прицепа.", example = "1", required = true, position = 8)
    @JsonProperty("trailerId")
    private Long trailerId;

    @ApiModelProperty(notes = "Наличие свободного места", example = "True", required = true, position = 9)
    @JsonProperty("hasSpace")
    private boolean hasSpace;

    public TripDto(Trip trip) {
        this.id = trip.getId();
        this.startTime = trip.getStartTime();
        this.endTime = trip.getEndTime();
        this.departure = trip.getDeparture();
        this.destination = trip.getDestination();
        this.carrierId = trip.getCarrier().getId();
        this.vehicleId = trip.getVehicle().getId();
        this.trailerId = trip.getTrailer().getId();
        this.hasSpace = trip.isHasSpace();
    }
}
