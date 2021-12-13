package com.olegzakhlivnyy.justcargo.services.interfaces;

import com.olegzakhlivnyy.justcargo.entities.dtos.DeliveryDto;

import java.util.List;

public interface DeliveryService {

    DeliveryDto findById(Long id);

    List<DeliveryDto> findByRequestId(Long id);

    List<DeliveryDto> findByTripId(Long id);

    DeliveryDto saveOrUpdate(DeliveryDto deliveryDto);

    void deleteById(Long id);
}
