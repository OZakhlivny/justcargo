package com.olegzakhlivnyy.justcargo.controllers.interfaces;

import com.olegzakhlivnyy.justcargo.entities.dtos.RequestStatusDto;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(value = "/api/requeststatuses", tags = "Контроллер для работы со статусами заявок", produces = "application/json")
@RequestMapping(value = "/api/requeststatuses", produces = "application/json")
public interface RequestStatusController {
    @ApiOperation(value = "Получить статус заявки по его id",
            httpMethod = "GET",
            produces = "application/json",
            response = RequestStatusDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = RequestStatusDto.class),
            @ApiResponse(code = 400, message = "Указан некорректный id"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Статус заявки с указанным id отсутствует")
    })
    @GetMapping(value = "/{id}", produces = "application/json")
    RequestStatusDto getById(@ApiParam(value = "идентификатор статуса заявки",  required = true, example = "1") @PathVariable Long id);

    @ApiOperation(value = "Получить список статусов заявок",
            httpMethod = "GET",
            produces = "application/json",
            response = RequestStatusDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = RequestStatusDto.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Ресурс отсутствует")
    })
    @GetMapping
    List<RequestStatusDto> getAllRequestStatuses();
}
