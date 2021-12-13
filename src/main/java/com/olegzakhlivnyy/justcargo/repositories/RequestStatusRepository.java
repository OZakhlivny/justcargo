package com.olegzakhlivnyy.justcargo.repositories;

import com.olegzakhlivnyy.justcargo.entities.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface RequestStatusRepository extends JpaRepository<RequestStatus, Long> {
    Optional<RequestStatus> findOneByName(@NotNull String name);
}
