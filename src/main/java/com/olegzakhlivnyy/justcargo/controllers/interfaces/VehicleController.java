package com.olegzakhlivnyy.justcargo.controllers.interfaces;

import com.olegzakhlivnyy.justcargo.entities.dtos.VehicleDto;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "/api/vehicles", tags = "Контроллер для работы с транспортными средствами", produces = "application/json")
@RequestMapping(value = "/api/vehicles", produces = "application/json")
public interface VehicleController {
    @ApiOperation(value = "Получить транспортное средство по его id",
            httpMethod = "GET",
            produces = "application/json",
            response = VehicleDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = VehicleDto.class),
            @ApiResponse(code = 400, message = "Указан некорректный id"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Транспортное средство с указанным id отсутствует")
    })
    @GetMapping(value = "/{id}", produces = "application/json")
    VehicleDto getById(@ApiParam(value = "идентификатор транспортного средства",  required = true, example = "1") @PathVariable Long id);

    @ApiOperation(value = "Получить все транспортные средства по id владельца",
            httpMethod = "GET",
            produces = "application/json",
            response = VehicleDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = VehicleDto.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Указан некорректный id"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав")
    })
    @GetMapping(value = "/owner/{id}", produces = "application/json")
    List<VehicleDto> getAllByOwnerId(@ApiParam(value = "идентификатор владельца",  required = true, example = "1") @PathVariable Long id);

    @ApiOperation(value = "Сохранить/создать транспортное средство",
            httpMethod = "POST",
            consumes = "application/json",
            produces = "application/json",
            response = VehicleDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = VehicleDto.class),
            @ApiResponse(code = 201, message = "Транспортное средство успешно сохранено/создано", response = VehicleDto.class),
            @ApiResponse(code = 400, message = "Некорректное тело запроса"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Ресурс отсутствует")
    })
    @PostMapping(consumes = "application/json", produces = "application/json")
    VehicleDto saveOrUpdate(@ApiParam(value = "JSON представление данных транспортного средства",  required = true) @RequestBody VehicleDto vehicleDto);

    @ApiOperation(value = "Удалить транспортное средство",
            httpMethod = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Некорректное тело запроса"),
            @ApiResponse(code = 401, message = "Клиент не авторизован"),
            @ApiResponse(code = 403, message = "Нет прав"),
            @ApiResponse(code = 404, message = "Ресурс отсутствует")
    })
    @DeleteMapping(value = "/{id}")
    void deleteVehicleById(@ApiParam(value = "идентификатор удаляемого транспортного средства", required = true, example = "1") @PathVariable Long id);

}
