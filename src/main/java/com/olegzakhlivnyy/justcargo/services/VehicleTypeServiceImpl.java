package com.olegzakhlivnyy.justcargo.services;

import com.olegzakhlivnyy.justcargo.entities.VehicleType;
import com.olegzakhlivnyy.justcargo.entities.dtos.UserTypeDto;
import com.olegzakhlivnyy.justcargo.entities.dtos.VehicleTypeDto;
import com.olegzakhlivnyy.justcargo.exceptions.ResourceNotFoundException;
import com.olegzakhlivnyy.justcargo.repositories.VehicleTypeRepository;
import com.olegzakhlivnyy.justcargo.services.interfaces.VehicleTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleTypeServiceImpl implements VehicleTypeService {
    private final VehicleTypeRepository vehicleTypeRepository;

    @Override
    public List<VehicleTypeDto> findAll() {
        return vehicleTypeRepository.findAll().stream().map(VehicleTypeDto::new).collect(Collectors.toList());
    }

    @Override
    public VehicleTypeDto findById(Long id) {
        return new VehicleTypeDto(vehicleTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Тип транспортного средства с id = %d не найден", id))));

    }

    @Override
    public VehicleType findEntityById(Long id) {
        return vehicleTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Тип транспортного средства с id = %d не найден", id)));

    }

    @Override
    public VehicleTypeDto findOneByName(String name) {
        return new VehicleTypeDto(vehicleTypeRepository.findOneByName(name)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Тип транспортного средства с наименованием = \"%s\" не найден", name))));

    }
}
