package com.olegzakhlivnyy.justcargo.controllers.interfaces;

import com.olegzakhlivnyy.justcargo.entities.dtos.RequestDto;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "/api/requests", tags = "Контроллер для работы с заявками", produces = "application/json")
@RequestMapping(value = "/api/requests", produces = "application/json")
public interface RequestController {
    @ApiOperation(value = "Получить заявку по её id",
            httpMethod = "GET",
            produces = "application/json",
            response = RequestDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = RequestDto.class),
            @ApiResponse(code = 400, message = "Указан некорректный id"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Заявка с указанным id отсутствует")
    })
    @GetMapping(value = "/{id}", produces = "application/json")
    RequestDto getById(@ApiParam(value = "идентификатор заявки",  required = true, example = "1") @PathVariable Long id);

    @ApiOperation(value = "Получить все заявки по id владельца",
            httpMethod = "GET",
            produces = "application/json",
            response = RequestDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = RequestDto.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав")
    })
    @GetMapping(value = "/owner/{id}", produces = "application/json")
    List<RequestDto> getAllByOwnerId(@ApiParam(value = "идентификатор владельца",  required = true, example = "1") @PathVariable Long id);

    @ApiOperation(value = "Получить все заявки по пункту отправления",
            httpMethod = "GET",
            produces = "application/json",
            response = RequestDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = RequestDto.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав")
    })
    @GetMapping(value = "/departure/{departure}", produces = "application/json")
    List<RequestDto> getAllByDeparture(@ApiParam(value = "наименование пункта отправления",  required = true, example = "Москва") @PathVariable String departure);

    @ApiOperation(value = "Получить все заявки по пункту назначения",
            httpMethod = "GET",
            produces = "application/json",
            response = RequestDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = RequestDto.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав")
    })
    @GetMapping(value = "/destination/{destination}", produces = "application/json")
    List<RequestDto> getAllByDestination(@ApiParam(value = "наименование пункта назначения",  required = true, example = "Москва") @PathVariable String destination);

    @ApiOperation(value = "Сохранить/создать заявку",
            httpMethod = "POST",
            consumes = "application/json",
            produces = "application/json",
            response = RequestDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = RequestDto.class),
            @ApiResponse(code = 201, message = "Заявка успешно сохранена/создана", response = RequestDto.class),
            @ApiResponse(code = 400, message = "Некорректное тело запроса"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Ресурс отсутствует")
    })
    @PostMapping(consumes = "application/json", produces = "application/json")
    RequestDto saveOrUpdate(@ApiParam(value = "JSON представление данных заявки",  required = true) @RequestBody RequestDto requestDto);

    @ApiOperation(value = "Удалить заявку",
            httpMethod = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Некорректное тело запроса"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Ресурс отсутствует")
    })
    @DeleteMapping(value = "/{id}")
    void deleteRequestById(@ApiParam(value = "идентификатор удаляемой заявки", required = true, example = "1") @PathVariable Long id);

}
