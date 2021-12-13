package com.olegzakhlivnyy.justcargo.controllers.interfaces;

import com.olegzakhlivnyy.justcargo.entities.dtos.RequestDto;
import com.olegzakhlivnyy.justcargo.entities.dtos.TripDto;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "/api/trips", tags = "Контроллер для работы с рейсами", produces = "application/json")
@RequestMapping(value = "/api/trips", produces = "application/json")
public interface TripController {
    @ApiOperation(value = "Получить рейс по его id",
            httpMethod = "GET",
            produces = "application/json",
            response = TripDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = TripDto.class),
            @ApiResponse(code = 400, message = "Указан некорректный id"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Рейс с указанным id отсутствует")
    })
    @GetMapping(value = "/{id}", produces = "application/json")
    TripDto getById(@ApiParam(value = "идентификатор рейса",  required = true, example = "1") @PathVariable Long id);

    @ApiOperation(value = "Получить все рейсы по id перевозчика",
            httpMethod = "GET",
            produces = "application/json",
            response = TripDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = TripDto.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав")
    })
    @GetMapping(value = "/carrier/{id}", produces = "application/json")
    List<TripDto> getAllByCarrierId(@ApiParam(value = "идентификатор перевозчика",  required = true, example = "1") @PathVariable Long id);

    @ApiOperation(value = "Получить все рейсы по пункту отправления",
            httpMethod = "GET",
            produces = "application/json",
            response = TripDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = TripDto.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав")
    })
    @GetMapping(value = "/departure/{departure}", produces = "application/json")
    List<TripDto> getAllByDeparture(@ApiParam(value = "наименование пункта отправления",  required = true, example = "Москва") @PathVariable String departure);

    @ApiOperation(value = "Получить все рейсы по пункту назначения",
            httpMethod = "GET",
            produces = "application/json",
            response = TripDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = TripDto.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав")
    })
    @GetMapping(value = "/destination/{destination}", produces = "application/json")
    List<TripDto> getAllByDestination(@ApiParam(value = "наименование пункта назначения",  required = true, example = "Москва") @PathVariable String destination);

    @ApiOperation(value = "Сохранить/создать рейс",
            httpMethod = "POST",
            consumes = "application/json",
            produces = "application/json",
            response = TripDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = TripDto.class),
            @ApiResponse(code = 201, message = "Рейс успешно сохранен/создан", response = TripDto.class),
            @ApiResponse(code = 400, message = "Некорректное тело запроса"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Ресурс отсутствует")
    })
    @PostMapping(consumes = "application/json", produces = "application/json")
    TripDto saveOrUpdate(@ApiParam(value = "JSON представление данных рейса",  required = true) @RequestBody TripDto tripDto);

    @ApiOperation(value = "Удалить рейс",
            httpMethod = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Некорректное тело запроса"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Ресурс отсутствует")
    })
    @DeleteMapping(value = "/{id}")
    void deleteTripById(@ApiParam(value = "идентификатор удаляемого рейса", required = true, example = "1") @PathVariable Long id);

}
