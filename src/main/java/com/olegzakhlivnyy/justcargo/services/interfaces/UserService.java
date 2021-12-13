package com.olegzakhlivnyy.justcargo.services.interfaces;

import com.olegzakhlivnyy.justcargo.entities.User;
import com.olegzakhlivnyy.justcargo.entities.dtos.UserDto;

public interface UserService {
    UserDto findById(Long id);

    User findEntityById(Long id);

    UserDto findByLogin(String login);

    UserDto saveOrUpdate(UserDto userDto);

    boolean isPresent(String login);
}
