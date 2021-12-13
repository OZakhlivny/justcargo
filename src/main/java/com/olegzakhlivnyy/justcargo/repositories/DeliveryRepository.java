package com.olegzakhlivnyy.justcargo.repositories;

import com.olegzakhlivnyy.justcargo.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    @Query("SELECT d FROM Delivery d WHERE d.request.id = ?1")
    List<Delivery> findByRequestId(@NotNull Long id);

    @Query("SELECT d FROM Delivery d WHERE d.trip.id = ?1")
    List<Delivery> findByTripId(@NotNull Long id);
}
