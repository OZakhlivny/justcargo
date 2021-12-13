package com.olegzakhlivnyy.justcargo.services;

import com.olegzakhlivnyy.justcargo.entities.Delivery;
import com.olegzakhlivnyy.justcargo.entities.dtos.DeliveryDto;
import com.olegzakhlivnyy.justcargo.exceptions.ResourceNotFoundException;
import com.olegzakhlivnyy.justcargo.repositories.DeliveryRepository;
import com.olegzakhlivnyy.justcargo.services.interfaces.DeliveryService;
import com.olegzakhlivnyy.justcargo.services.interfaces.RequestService;
import com.olegzakhlivnyy.justcargo.services.interfaces.TripService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final RequestService requestService;
    private final TripService tripService;

    @Override
    public DeliveryDto findById(Long id) {
        return new DeliveryDto(deliveryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("Доставка с id = %d не найдена", id))));
    }

    @Override
    public List<DeliveryDto> findByRequestId(Long id) {
        return deliveryRepository.findByRequestId(id).stream().map(DeliveryDto::new).collect(Collectors.toList());
    }

    @Override
    public List<DeliveryDto> findByTripId(Long id) {
        return deliveryRepository.findByTripId(id).stream().map(DeliveryDto::new).collect(Collectors.toList()) ;
    }

    @Override
    public DeliveryDto saveOrUpdate(DeliveryDto deliveryDto) {
        Delivery delivery;
        if(deliveryDto.getId() == null) delivery = new Delivery();
        else delivery = deliveryRepository.findById(deliveryDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Доставка с id = %s не найдена", deliveryDto.getId())));

        delivery.setRequest(requestService.findEntityById(deliveryDto.getRequestId()));
        delivery.setTrip(tripService.findEntityById(deliveryDto.getTripId()));
        delivery.setStartTime(deliveryDto.getStartTime());
        delivery.setEndTime(deliveryDto.getEndTime());

        return new DeliveryDto(deliveryRepository.save(delivery));
    }

    @Override
    public void deleteById(Long id) {
        deliveryRepository.deleteById(id);
    }
}
