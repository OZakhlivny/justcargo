package com.olegzakhlivnyy.justcargo.services.interfaces;

import com.olegzakhlivnyy.justcargo.entities.VehicleType;
import com.olegzakhlivnyy.justcargo.entities.dtos.VehicleTypeDto;

import java.util.List;

public interface VehicleTypeService {
    List<VehicleTypeDto> findAll();

    VehicleTypeDto findById(Long id);

    VehicleType findEntityById(Long id);

    VehicleTypeDto findOneByName(String name);
}
