package com.olegzakhlivnyy.justcargo.repositories;

import com.olegzakhlivnyy.justcargo.entities.UserClass;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface UserClassRepository extends JpaRepository<UserClass, Long> {
    Optional<UserClass> findOneByName(@NotNull String name);
}
