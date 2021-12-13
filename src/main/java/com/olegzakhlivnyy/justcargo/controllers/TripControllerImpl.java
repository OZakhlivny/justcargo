package com.olegzakhlivnyy.justcargo.controllers;

import com.olegzakhlivnyy.justcargo.controllers.interfaces.TripController;
import com.olegzakhlivnyy.justcargo.entities.dtos.TripDto;
import com.olegzakhlivnyy.justcargo.services.interfaces.TripService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TripControllerImpl implements TripController {

    private final TripService tripService;

    @Override
    public TripDto getById(Long id) {
        return tripService.findById(id);
    }

    @Override
    public List<TripDto> getAllByCarrierId(Long id) {
        return tripService.findByCarrierId(id);
    }

    @Override
    public List<TripDto> getAllByDeparture(String departure) {
        return tripService.findByDeparture(departure);
    }

    @Override
    public List<TripDto> getAllByDestination(String destination) {
        return tripService.findByDestination(destination);
    }

    @Override
    public TripDto saveOrUpdate(TripDto tripDto) {
        return tripService.saveOrUpdate(tripDto);
    }

    @Override
    public void deleteTripById(Long id) {
        tripService.deleteById(id);
    }
}
