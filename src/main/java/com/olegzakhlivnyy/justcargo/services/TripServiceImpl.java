package com.olegzakhlivnyy.justcargo.services;

import com.olegzakhlivnyy.justcargo.entities.Trip;
import com.olegzakhlivnyy.justcargo.entities.dtos.TripDto;
import com.olegzakhlivnyy.justcargo.exceptions.ResourceNotFoundException;
import com.olegzakhlivnyy.justcargo.repositories.TripRepository;
import com.olegzakhlivnyy.justcargo.services.interfaces.TripService;
import com.olegzakhlivnyy.justcargo.services.interfaces.UserService;
import com.olegzakhlivnyy.justcargo.services.interfaces.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;
    private final UserService userService;
    private final VehicleService vehicleService;

    @Override
    public TripDto findById(Long id) {
        return new TripDto(tripRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Рейс с id = %d не найден", id))));
    }

    @Override
    public Trip findEntityById(Long id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Рейс с id = %d не найден", id)));
    }

    @Override
    public List<TripDto> findByDeparture(String departure) {
        return tripRepository.findByDeparture(departure).stream().map(TripDto::new).collect(Collectors.toList());
    }

    @Override
    public List<TripDto> findByDestination(String destination) {
        return tripRepository.findByDestination(destination).stream().map(TripDto::new).collect(Collectors.toList());
    }

    @Override
    public List<TripDto> findByCarrierId(Long id) {
        return tripRepository.findByCarrierId(id).stream().map(TripDto::new).collect(Collectors.toList());
    }

    @Override
    public TripDto saveOrUpdate(TripDto tripDto) {
        Trip trip;
        if(tripDto.getId() == null) trip = new Trip();
        else trip = tripRepository.findById(tripDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Рейс с id = %d не найден", tripDto.getId())));

        trip.setStartTime(tripDto.getStartTime());
        trip.setEndTime(tripDto.getEndTime());
        trip.setDeparture(tripDto.getDeparture());
        trip.setDestination(tripDto.getDestination());
        trip.setCarrier(userService.findEntityById(tripDto.getCarrierId()));
        trip.setVehicle(vehicleService.findEntityById(tripDto.getVehicleId()));
        trip.setTrailer(vehicleService.findEntityById(tripDto.getTrailerId()));
        trip.setHasSpace(tripDto.isHasSpace());

        return new TripDto(tripRepository.save(trip));
    }

    @Override
    public void deleteById(Long id) {
        tripRepository.deleteById(id);
    }
}
