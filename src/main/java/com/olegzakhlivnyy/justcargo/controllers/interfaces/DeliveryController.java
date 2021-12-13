package com.olegzakhlivnyy.justcargo.controllers.interfaces;

import com.olegzakhlivnyy.justcargo.entities.dtos.DeliveryDto;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "/api/deliveries", tags = "Контроллер для работы с доставками", produces = "application/json")
@RequestMapping(value = "/api/deliveries", produces = "application/json")
public interface DeliveryController {

    @ApiOperation(value = "Получить доставку по её id",
            httpMethod = "GET",
            produces = "application/json",
            response = DeliveryDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = DeliveryDto.class),
            @ApiResponse(code = 400, message = "Указан некорректный id"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Ресурс отсутствует")
    })
    @GetMapping(value = "/{id}", produces = "application/json")
    DeliveryDto getById(@ApiParam(value = "идентификатор доставки",  required = true, example = "1") @PathVariable Long id);

    @ApiOperation(value = "Получить список доставок по id заявки",
            httpMethod = "GET",
            produces = "application/json",
            response = DeliveryDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = DeliveryDto.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав")
    })
    @GetMapping(value = "/request/{id}", produces = "application/json")
    List<DeliveryDto> getAllByRequestId(@ApiParam(value = "идентификатор заявки",  required = true, example = "1") @PathVariable Long id);

    @ApiOperation(value = "Получить список доставок по id рейса",
            httpMethod = "GET",
            produces = "application/json",
            response = DeliveryDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = DeliveryDto.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав")
    })
    @GetMapping(value = "/trip/{id}", produces = "application/json")
    List<DeliveryDto> getAllByTripId(@ApiParam(value = "идентификатор рейса",  required = true, example = "1") @PathVariable Long id);

    @ApiOperation(value = "Сохранить/создать доставку",
            httpMethod = "POST",
            consumes = "application/json",
            produces = "application/json",
            response = DeliveryDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = DeliveryDto.class),
            @ApiResponse(code = 201, message = "Доставка успешно сохранена/создана", response = DeliveryDto.class),
            @ApiResponse(code = 400, message = "Некорректное тело запроса"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Ресурс отсутствует")
    })
    @PostMapping(consumes = "application/json", produces = "application/json")
    DeliveryDto saveOrUpdate(@ApiParam(value = "JSON представление данных доставки",  required = true) @RequestBody DeliveryDto deliveryDto);

    @ApiOperation(value = "Удалить доставку",
            httpMethod = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Некорректное тело запроса"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Ресурс отсутствует")
    })
    @DeleteMapping(value = "/{id}")
    void deleteDeliveryById(@ApiParam(value = "идентификатор удаляемой доставки", required = true, example = "1") @PathVariable Long id);

}
