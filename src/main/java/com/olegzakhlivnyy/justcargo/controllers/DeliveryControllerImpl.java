package com.olegzakhlivnyy.justcargo.controllers;

import com.olegzakhlivnyy.justcargo.controllers.interfaces.DeliveryController;
import com.olegzakhlivnyy.justcargo.entities.dtos.DeliveryDto;
import com.olegzakhlivnyy.justcargo.services.interfaces.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DeliveryControllerImpl implements DeliveryController {

    private final DeliveryService deliveryService;

    @Override
    public DeliveryDto getById(Long id) {
        return deliveryService.findById(id);
    }

    @Override
    public List<DeliveryDto> getAllByRequestId(Long id) {
        return deliveryService.findByRequestId(id);
    }

    @Override
    public List<DeliveryDto> getAllByTripId(Long id) {
        return deliveryService.findByTripId(id);
    }

    @Override
    public DeliveryDto saveOrUpdate(DeliveryDto deliveryDto) {
        return deliveryService.saveOrUpdate(deliveryDto);
    }

    @Override
    public void deleteDeliveryById(Long id) {
        deliveryService.deleteById(id);
    }
}
