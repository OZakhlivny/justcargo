package com.olegzakhlivnyy.justcargo.controllers;

import com.olegzakhlivnyy.justcargo.controllers.interfaces.VehicleController;
import com.olegzakhlivnyy.justcargo.entities.dtos.VehicleDto;
import com.olegzakhlivnyy.justcargo.services.interfaces.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class VehicleControllerImpl implements VehicleController {

    private final VehicleService vehicleService;

    @Override
    public VehicleDto getById(Long id) {
        return vehicleService.findById(id);
    }

    @Override
    public List<VehicleDto> getAllByOwnerId(Long id) {
        return vehicleService.findByOwnerId(id);
    }

    @Override
    public VehicleDto saveOrUpdate(VehicleDto vehicleDto) {
        return vehicleService.saveOrUpdate(vehicleDto);
    }

    @Override
    public void deleteVehicleById(Long id) {
        vehicleService.deleteById(id);
    }
}
