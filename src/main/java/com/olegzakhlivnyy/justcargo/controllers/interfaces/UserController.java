package com.olegzakhlivnyy.justcargo.controllers.interfaces;

import com.olegzakhlivnyy.justcargo.entities.dtos.UserDto;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;


@Api(value = "/api/users", tags = "Контроллер для работы с пользователями", produces = "application/json")
@RequestMapping(value = "/api/users", produces = "application/json")
public interface UserController {
    @ApiOperation(value = "Получить пользователя по его id",
            httpMethod = "GET",
            produces = "application/json",
            response = UserDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UserDto.class),
            @ApiResponse(code = 400, message = "Указан некорректный id"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Пользователь с указанным id отсутствует")
    })
    @GetMapping(value = "/{id}", produces = "application/json")
    UserDto getById(@ApiParam(value = "идентификатор пользователя",  required = true, example = "1") @PathVariable Long id);

    @ApiOperation(value = "Получить пользователя по логину",
            httpMethod = "GET",
            produces = "application/json",
            response = UserDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UserDto.class),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Пользователь с указанным логином отсутствует")
    })
    @GetMapping(value = "/login/{login}", produces = "application/json")
    UserDto findByLogin(@ApiParam(value = "Логин пользователя",  required = true, example = "user1") @PathVariable String login);

    @ApiOperation(value = "Сохранить/создать пользователя",
            httpMethod = "POST",
            consumes = "application/json",
            produces = "application/json",
            response = UserDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UserDto.class),
            @ApiResponse(code = 201, message = "Пользователь успешно сохранен/создан", response = UserDto.class),
            @ApiResponse(code = 400, message = "Некорректное тело запроса"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Ресурс отсутствует")
    })
    @PostMapping(consumes = "application/json", produces = "application/json")
    UserDto saveOrUpdate(@ApiParam(value = "JSON представление данных пользователя",  required = true) @RequestBody UserDto userDto);
}
