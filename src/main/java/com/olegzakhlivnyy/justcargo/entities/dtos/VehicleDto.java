package com.olegzakhlivnyy.justcargo.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Класс Транспортное средство.")
@JsonRootName("VehicleDto")
public class VehicleDto {
    @ApiModelProperty(notes = "Уникальный идентификатор транспортного средства.", example = "1", required = true, position = 1)
    @JsonProperty("id")
    private Long id;

    @ApiModelProperty(notes = "Наименование транспортного средства", dataType = "String", example = "Контейнеровоз №1", required = true, position = 2)
    @JsonProperty("name")
    private String name;

    @ApiModelProperty(notes = "Описание транспортного средства", dataType = "String", example = "Контейнеровоз №1 с базированием в городе Москва", position = 3)
    @JsonProperty("description")
    private String description;

    @ApiModelProperty(notes = "Идентификатор владельца транспортного средства.", example = "1", required = true, position = 4)
    @JsonProperty("ownerId")
    private Long ownerId;

    @ApiModelProperty(notes = "Идентификатор типа транспортного средства.", example = "1", required = true, position = 5)
    @JsonProperty("typeId")
    private Long typeId;

    @ApiModelProperty(notes = "Номер госрегистрации транспортного средства.", dataType = "String", example = "а000АА000", required = true, position = 6)
    @JsonProperty("registrationNumber")
    private String registrationNumber;

    @ApiModelProperty(notes = "Грузоподъемность транспортного средства.", example = "1", required = true, position = 7)
    @JsonProperty("carryingCapacity")
    private Integer carryingCapacity;

    @ApiModelProperty(notes = "Размер грузового отсека: длина.", example = "1", required = true, position = 8)
    @JsonProperty("length")
    private Integer length;

    @ApiModelProperty(notes = "Размер грузового отсека: ширина.", example = "1", required = true, position = 9)
    @JsonProperty("width")
    private Integer width;

    @ApiModelProperty(notes = "Размер грузового отсека: высота.", example = "1", required = true, position = 10)
    @JsonProperty("height")
    private Integer height;

    @ApiModelProperty(notes = "Объем грузового отсека.", example = "1", required = true, position = 11)
    @JsonProperty("volume")
    private Float volume;
}
