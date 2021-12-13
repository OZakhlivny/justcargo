package com.olegzakhlivnyy.justcargo.repositories;

import com.olegzakhlivnyy.justcargo.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByDeparture(@NotNull String departure);
    List<Trip> findByDestination(@NotNull String destination);

    @Query("SELECT t FROM Trip t WHERE t.carrier.id = ?1")
    List<Trip> findByCarrierId(@NotNull Long id);
}
