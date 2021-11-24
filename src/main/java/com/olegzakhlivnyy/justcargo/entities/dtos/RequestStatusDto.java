package com.olegzakhlivnyy.justcargo.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.olegzakhlivnyy.justcargo.entities.RequestStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Класс Статус заявки.")
@JsonRootName("RequestStatusDto")
public class RequestStatusDto {
    @ApiModelProperty(notes = "Уникальный идентификатор статуса.", example = "1", required = true, position = 1)
    @JsonProperty("id")
    private Long id;

    @ApiModelProperty(notes = "Наименование статуса заявки.", example = "Открыта", required = true, position = 2)
    @JsonProperty("name")
    private String name;

    public RequestStatusDto(RequestStatus requestStatus){
        this.id = requestStatus.getId();
        this.name = requestStatus.getName();
    }
}
