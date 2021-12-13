package com.olegzakhlivnyy.justcargo.repositories;

import com.olegzakhlivnyy.justcargo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(@NotNull String login);

    boolean existsByLogin(@NotNull String login);
}
