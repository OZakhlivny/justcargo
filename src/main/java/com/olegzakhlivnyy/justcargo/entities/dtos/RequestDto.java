package com.olegzakhlivnyy.justcargo.entities.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
    @JsonProperty("timestamp")
    private OffsetDateTime requestTime;

    @ApiModelProperty(notes = "Требуемое время доставки груза", required = true, position = 3)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonProperty("timestamp")
    private OffsetDateTime deliveryTime;

    @ApiModelProperty(notes = "Краткое описание заявки", dataType = "String", example = "Доставить коробку в Москву", position = 4)
    @JsonProperty("shortInfo")
    private String shortInfo;

    @ApiModelProperty(notes = "Подробное описание заявки", dataType = "String", example = "Доставить коробку 1 шт в г. Москва, ул. Шаболовка д.37 до 31.12.2021 12:00", position = 5)
    @JsonProperty("description")
    private String description;

    @ApiModelProperty(notes = "Количество мест отправки.", example = "1", required = true, position = 6)
    @JsonProperty("packagesNumber")
    private Integer packagesNumber;

    @ApiModelProperty(notes = "Вес отправки.", example = "1", required = true, position = 7)
    @JsonProperty("weight")
    private Integer weight;

    @ApiModelProperty(notes = "Размер: длина.", example = "1", required = true, position = 8)
    @JsonProperty("length")
    private Integer length;

    @ApiModelProperty(notes = "Размер: ширина.", example = "1", required = true, position = 9)
    @JsonProperty("width")
    private Integer width;

    @ApiModelProperty(notes = "Размер: высота.", example = "1", required = true, position = 10)
    @JsonProperty("height")
    private Integer height;

    @ApiModelProperty(notes = "Идентификатор владельца.", example = "1", required = true, position = 11)
    @JsonProperty("ownerId")
    private Long ownerId;

    @ApiModelProperty(notes = "Идентификатор статуса заявки.", example = "1", required = true, position = 12)
    @JsonProperty("statusId")
    private Long statusId;
}
