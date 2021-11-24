package com.olegzakhlivnyy.justcargo.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.olegzakhlivnyy.justcargo.entities.UserType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Класс Тип пользователя.")
@JsonRootName("UserTypeDto")
public class UserTypeDto {
    @ApiModelProperty(notes = "Уникальный идентификатор типа.", example = "1", required = true, position = 1)
    @JsonProperty("id")
    private Long id;

    @ApiModelProperty(notes = "Наименование типа.", example = "Физическое лицо", required = true, position = 2)
    @JsonProperty("name")
    private String name;

    public UserTypeDto(UserType userType){
        this.id = userType.getId();
        this.name = userType.getName();
    }
}
