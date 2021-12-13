package com.olegzakhlivnyy.justcargo.controllers;

import com.olegzakhlivnyy.justcargo.controllers.interfaces.VehicleTypeController;
import com.olegzakhlivnyy.justcargo.entities.dtos.VehicleTypeDto;
import com.olegzakhlivnyy.justcargo.services.interfaces.VehicleTypeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class VehicleTypeControllerImpl implements VehicleTypeController {

    private final VehicleTypeService vehicleTypeService;

    @Override
    public VehicleTypeDto getById(Long id) {
        return vehicleTypeService.findById(id);
    }

    @Override
    public List<VehicleTypeDto> getAllVehicleTypes() {
        return vehicleTypeService.findAll();
    }
}
