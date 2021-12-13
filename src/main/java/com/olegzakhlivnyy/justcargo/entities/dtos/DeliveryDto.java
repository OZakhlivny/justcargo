package com.olegzakhlivnyy.justcargo.entities.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.olegzakhlivnyy.justcargo.entities.Delivery;
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
@ApiModel(description = "Класс Доставка.")
@JsonRootName("DeliveryDto")
public class DeliveryDto {
    @ApiModelProperty(notes = "Уникальный идентификатор доставки.", example = "1", required = true, position = 1)
    @JsonProperty("id")
    private Long id;

    @ApiModelProperty(notes = "Идентификатор заявки.", example = "1", required = true, position = 2)
    @JsonProperty("requestId")
    private Long requestId;

    @ApiModelProperty(notes = "Идентификатор рейса.", example = "1", required = true, position = 3)
    @JsonProperty("tripId")
    private Long tripId;

    @ApiModelProperty(notes = "Время отправки груза", required = true, position = 4)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonProperty("timestamp")
    private OffsetDateTime startTime;

    @ApiModelProperty(notes = "Время доставки груза", required = true, position = 5)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonProperty("timestamp")
    private OffsetDateTime endTime;

    public DeliveryDto(Delivery delivery) {
        this.id = delivery.getId();
        this.requestId = delivery.getRequest().getId();
        this.tripId = delivery.getTrip().getId();
        this.startTime = delivery.getStartTime();
        this.endTime = delivery.getEndTime();
    }
}
