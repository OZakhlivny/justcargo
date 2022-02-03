package com.olegzakhlivnyy.justcargo.controllers.interfaces;

import com.olegzakhlivnyy.justcargo.entities.dtos.UserClassDto;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(value = "/api/userclasses", tags = "Контроллер для работы с классами пользователей", produces = "application/json")
@RequestMapping(value = "/api/userclasses", produces = "application/json")
public interface UserClassController {
    @ApiOperation(value = "Получить класс пользователя по его id",
            httpMethod = "GET",
            produces = "application/json",
            response = UserClassDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UserClassDto.class),
            @ApiResponse(code = 400, message = "Указан некорректный id"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Класс пользователя с указанным id отсутствует")
    })
    @GetMapping(value = "/{id}", produces = "application/json")
    UserClassDto getById(@ApiParam(value = "идентификатор класса пользователя",  required = true, example = "1") @PathVariable Long id);

    @ApiOperation(value = "Получить список классов пользователей",
            httpMethod = "GET",
            produces = "application/json",
            response = UserClassDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UserClassDto.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Ресурс отсутствует")
    })
    @GetMapping
    List<UserClassDto> getAllUserClasses();

}
