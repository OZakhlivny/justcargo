package com.olegzakhlivnyy.justcargo.entities.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.olegzakhlivnyy.justcargo.entities.UserClass;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Класс пользователя.")
@JsonRootName("UserClassDto")
public class UserClassDto {
    @ApiModelProperty(notes = "Уникальный идентификатор класса.", example = "1", required = true, position = 1)
    @JsonProperty("id")
    private Long id;

    @ApiModelProperty(notes = "Наименование класса.", example = "Грузоперевозчик", required = true, position = 2)
    @JsonProperty("name")
    private String name;

    public UserClassDto(UserClass userClass){
        this.id = userClass.getId();
        this.name = userClass.getName();
    }
}
