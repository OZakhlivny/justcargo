package com.olegzakhlivnyy.justcargo.services.interfaces;

import com.olegzakhlivnyy.justcargo.entities.Vehicle;
import com.olegzakhlivnyy.justcargo.entities.dtos.VehicleDto;

import java.util.List;

public interface VehicleService {
    VehicleDto findById(Long id);

    Vehicle findEntityById(Long id);

    List<VehicleDto> findByOwnerId(Long id);

    VehicleDto saveOrUpdate(VehicleDto vehicleDto);

    void deleteById(Long id);
}
