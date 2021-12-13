package com.olegzakhlivnyy.justcargo.entities.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.olegzakhlivnyy.justcargo.entities.Request;
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
@ApiModel(description = "Класс Заявка.")
@JsonRootName("RequestDto")
public class RequestDto {
    @ApiModelProperty(notes = "Уникальный идентификатор заявки.", example = "1", required = true, position = 1)
    @JsonProperty("id")
    private Long id;

    @ApiModelProperty(notes = "Время размещения заявки", required = true, position = 2)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonProperty("requestTime")
    private OffsetDateTime requestTime;

    @ApiModelProperty(notes = "Требуемое время доставки груза", required = true, position = 3)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonProperty("deliveryTime")
    private OffsetDateTime deliveryTime;

    @ApiModelProperty(notes = "Конечное время доставки груза (в случае указания периода)", required = true, position = 4)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonProperty("deliveryTimeLimit")
    private OffsetDateTime deliveryTimeLimit;

    @ApiModelProperty(notes = "Адрес забора груза", dataType = "String", example = "Воронеж", position = 5)
    @JsonProperty("departure")
    private String departure;

    @ApiModelProperty(notes = "Адрес доставки груза", dataType = "String", example = "Москва", position = 6)
    @JsonProperty("destination")
    private String destination;

    @ApiModelProperty(notes = "Краткое описание заявки", dataType = "String", example = "Доставить коробку в Москву", position = 7)
    @JsonProperty("shortInfo")
    private String shortInfo;

    @ApiModelProperty(notes = "Подробное описание заявки", dataType = "String", example = "Доставить коробку 1 шт в г. Москва, ул. Шаболовка д.37 до 31.12.2021 12:00", position = 8)
    @JsonProperty("description")
    private String description;

    @ApiModelProperty(notes = "Количество мест отправки.", example = "1", required = true, position = 9)
    @JsonProperty("packagesNumber")
    private Integer packagesNumber;

    @ApiModelProperty(notes = "Вес отправки.", example = "1", required = true, position = 10)
    @JsonProperty("weight")
    private Integer weight;

    @ApiModelProperty(notes = "Размер: длина.", example = "1", required = true, position = 11)
    @JsonProperty("length")
    private Integer length;

    @ApiModelProperty(notes = "Размер: ширина.", example = "1", required = true, position = 12)
    @JsonProperty("width")
    private Integer width;

    @ApiModelProperty(notes = "Размер: высота.", example = "1", required = true, position = 13)
    @JsonProperty("height")
    private Integer height;

    @ApiModelProperty(notes = "Предлагаемая стоимость доставки.", example = "100", required = true, position = 14)
    @JsonProperty("cost")
    private Integer cost;

    @ApiModelProperty(notes = "Идентификатор владельца.", example = "1", required = true, position = 15)
    @JsonProperty("ownerId")
    private Long ownerId;

    @ApiModelProperty(notes = "Идентификатор статуса заявки.", example = "1", required = true, position = 16)
    @JsonProperty("statusId")
    private Long statusId;

    public RequestDto(Request request) {
        this.id = request.getId();
        this.requestTime = request.getRequestTime();
        this.deliveryTime = request.getDeliveryTime();
        this.deliveryTimeLimit = request.getDeliveryTimeLimit();
        this.departure = request.getDeparture();
        this.destination = request.getDestination();
        this.shortInfo = request.getShortInfo();
        this.description = request.getDescription();
        this.packagesNumber = request.getPackagesNumber();
        this.weight = request.getWeight();
        this.length = request.getLength();
        this.width = request.getWidth();
        this.height = request.getHeight();
        this.cost = request.getCost();
        this.ownerId = request.getOwner().getId();
        this.statusId = request.getStatus().getId();
    }
}
