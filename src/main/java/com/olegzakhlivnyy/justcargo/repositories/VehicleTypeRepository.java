package com.olegzakhlivnyy.justcargo.repositories;

import com.olegzakhlivnyy.justcargo.entities.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
    Optional<VehicleType> findOneByName(@NotNull String name);
}
