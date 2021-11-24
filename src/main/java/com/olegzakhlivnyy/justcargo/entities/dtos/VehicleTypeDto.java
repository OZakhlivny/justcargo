package com.olegzakhlivnyy.justcargo.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.olegzakhlivnyy.justcargo.entities.VehicleType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Класс Вид транспортного средства.")
@JsonRootName("VehicleTypeDto")
public class VehicleTypeDto {
    @ApiModelProperty(notes = "Уникальный идентификатор вида.", example = "1", required = true, position = 1)
    @JsonProperty("id")
    private Long id;

    @ApiModelProperty(notes = "Наименование вида транспортного средства.", example = "Контейнеровоз", required = true, position = 2)
    @JsonProperty("name")
    private String name;

    public VehicleTypeDto(VehicleType vehicleType){
        this.id = vehicleType.getId();
        this.name = vehicleType.getName();
    }
}
