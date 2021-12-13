package com.olegzakhlivnyy.justcargo.services.interfaces;

import com.olegzakhlivnyy.justcargo.entities.Trip;
import com.olegzakhlivnyy.justcargo.entities.dtos.TripDto;

import java.util.List;

public interface TripService {
    TripDto findById(Long id);

    Trip findEntityById(Long id);

    List<TripDto> findByDeparture(String departure);

    List<TripDto> findByDestination(String destination);

    List<TripDto> findByCarrierId(Long id);

    TripDto saveOrUpdate(TripDto tripDto);

    void deleteById(Long id);
}
