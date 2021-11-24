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
@ApiModel(description = "Класс Пользователь.")
@JsonRootName("UserDto")
public class UserDto {

    @ApiModelProperty(notes = "Уникальный идентификатор пользователя", example = "1", required = true, position = 1)
    @JsonProperty("id")
    private Long id;

    @ApiModelProperty(notes = "Логин пользователя", example = "User", required = true, position = 2)
    @JsonProperty("login")
    private String login;

    @ApiModelProperty(notes = "Пароль пользователя", example = "123", required = true, position = 3)
    @JsonProperty("password")
    private String password;

    @ApiModelProperty(notes = "Активность пользователя", example = "True", required = true, position = 4)
    @JsonProperty("enabled")
    private boolean enabled;

    @ApiModelProperty(notes = "Имя пользователя", dataType = "String", example = "Иван", required = true, position = 5)
    @JsonProperty("name")
    private String name;

    @ApiModelProperty(notes = "Фамилия пользователя", dataType = "String", example = "Иванов", required = true, position = 6)
    @JsonProperty("surname")
    private String surname;

    @ApiModelProperty(notes = "Номер телефона пользователя", dataType = "String", example = "89998887766", position = 7)
    @JsonProperty("phone")
    private String phone;

    @ApiModelProperty(notes = "Электронная почта пользователя", dataType = "String", example = "ivan@mail.ru", position = 8)
    @JsonProperty("email")
    private String email;

    @ApiModelProperty(notes = "Идентификатор типа пользователя.", example = "1", required = true, position = 9)
    @JsonProperty("userTypeId")
    private Long userTypeId;

    @ApiModelProperty(notes = "Идентификатор класса пользователя.", example = "1", required = true, position = 10)
    @JsonProperty("userClassId")
    private Long userClassId;
}
