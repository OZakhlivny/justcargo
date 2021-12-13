package com.olegzakhlivnyy.justcargo.repositories;

import com.olegzakhlivnyy.justcargo.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("SELECT v FROM Vehicle v WHERE v.owner.id = ?1")
    List<Vehicle> findByOwnerId(@NotNull Long id);
}
