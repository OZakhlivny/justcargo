package com.olegzakhlivnyy.justcargo.controllers.interfaces;


import com.olegzakhlivnyy.justcargo.entities.dtos.UserTypeDto;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(value = "/api/usertypes", tags = "Контроллер для работы с типами пользователей", produces = "application/json")
@RequestMapping(value = "/api/usertypes", produces = "application/json")
public interface UserTypeController {
    @ApiOperation(value = "Получить тип пользователя по его id",
            httpMethod = "GET",
            produces = "application/json",
            response = UserTypeDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UserTypeDto.class),
            @ApiResponse(code = 400, message = "Указан некорректный id"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Тип пользователя с указанным id отсутствует")
    })
    @GetMapping(value = "/{id}", produces = "application/json")
    UserTypeDto getById(@ApiParam(value = "идентификатор типа пользователя",  required = true, example = "1") @PathVariable Long id);

    @ApiOperation(value = "Получить список типов пользователей",
            httpMethod = "GET",
            produces = "application/json",
            response = UserTypeDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UserTypeDto.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Ресурс отсутствует")
    })
    @GetMapping
    List<UserTypeDto> getAllUserTypes();
}
