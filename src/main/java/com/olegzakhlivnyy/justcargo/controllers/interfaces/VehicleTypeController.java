package com.olegzakhlivnyy.justcargo.controllers.interfaces;

import com.olegzakhlivnyy.justcargo.entities.dtos.VehicleTypeDto;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(value = "/api/vehicletypes", tags = "Контроллер для работы с типами транспортных средств", produces = "application/json")
@RequestMapping(value = "/api/vehicletypes", produces = "application/json")
public interface VehicleTypeController {
    @ApiOperation(value = "Получить тип транспортного средства по его id",
            httpMethod = "GET",
            produces = "application/json",
            response = VehicleTypeDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = VehicleTypeDto.class),
            @ApiResponse(code = 400, message = "Указан некорректный id"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Тип транспортного средства с указанным id отсутствует")
    })
    @GetMapping(value = "/{id}", produces = "application/json")
    VehicleTypeDto getById(@ApiParam(value = "идентификатор типа транспортного средства",  required = true, example = "1") @PathVariable Long id);

    @ApiOperation(value = "Получить список типов транспортных средств",
            httpMethod = "GET",
            produces = "application/json",
            response = VehicleTypeDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = VehicleTypeDto.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Ресурс отсутствует")
    })
    @GetMapping
    List<VehicleTypeDto> getAllVehicleTypes();
}
