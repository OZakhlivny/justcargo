package com.olegzakhlivnyy.justcargo.services;

import com.olegzakhlivnyy.justcargo.entities.Vehicle;
import com.olegzakhlivnyy.justcargo.entities.dtos.VehicleDto;
import com.olegzakhlivnyy.justcargo.exceptions.ResourceNotFoundException;
import com.olegzakhlivnyy.justcargo.repositories.VehicleRepository;
import com.olegzakhlivnyy.justcargo.services.interfaces.UserService;
import com.olegzakhlivnyy.justcargo.services.interfaces.VehicleService;
import com.olegzakhlivnyy.justcargo.services.interfaces.VehicleTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final UserService userService;
    private final VehicleTypeService vehicleTypeService;

    @Override
    public VehicleDto findById(Long id) {
        return new VehicleDto(vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Транспортное средство с id = %d не найдено", id))));
    }

    @Override
    public Vehicle findEntityById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Транспортное средство с id = %d не найдено", id)));
    }

    @Override
    public List<VehicleDto> findByOwnerId(Long id) {
        return vehicleRepository.findByOwnerId(id).stream().map(VehicleDto::new).collect(Collectors.toList());
    }

    @Override
    public VehicleDto saveOrUpdate(VehicleDto vehicleDto) {
        Vehicle vehicle;
        if(vehicleDto.getId() == null) vehicle = new Vehicle();
        else vehicle = vehicleRepository.findById(vehicleDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Транспортное средство с id = %d не найдено", vehicleDto.getId())));

        vehicle.setName(vehicleDto.getName());
        vehicle.setDescription(vehicleDto.getDescription());
        vehicle.setOwner(userService.findEntityById(vehicleDto.getOwnerId()));
        vehicle.setType(vehicleTypeService.findEntityById(vehicleDto.getTypeId()));
        vehicle.setRegistrationNumber(vehicleDto.getRegistrationNumber());
        vehicle.setCarryingCapacity(vehicleDto.getCarryingCapacity());
        vehicle.setLength(vehicleDto.getLength());
        vehicle.setWidth(vehicleDto.getWidth());
        vehicle.setHeight(vehicleDto.getHeight());
        vehicle.setVolume(vehicleDto.getVolume());
        
        return new VehicleDto(vehicleRepository.save(vehicle));
    }

    @Override
    public void deleteById(Long id) {
        vehicleRepository.deleteById(id);
    }
}
