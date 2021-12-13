package com.olegzakhlivnyy.justcargo.repositories;

import com.olegzakhlivnyy.justcargo.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findByDeparture(@NotNull String departure);
    List<Request> findByDestination(@NotNull String destination);

    @Query("SELECT r FROM Request r WHERE r.owner.id = ?1")
    List<Request> findByOwnerId(@NotNull Long id);
}
