package com.olegzakhlivnyy.justcargo.repositories;

import com.olegzakhlivnyy.justcargo.entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {
    Optional<UserType> findOneByName(@NotNull String name);
}
