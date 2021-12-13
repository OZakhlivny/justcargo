package com.olegzakhlivnyy.justcargo.controllers;

import com.olegzakhlivnyy.justcargo.controllers.interfaces.UserController;
import com.olegzakhlivnyy.justcargo.entities.dtos.UserDto;
import com.olegzakhlivnyy.justcargo.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public UserDto getById(Long id) {
        return userService.findById(id);
    }

    @Override
    public UserDto findByLogin(String login) {
        return userService.findByLogin(login);
    }

    @Override
    public UserDto saveOrUpdate(UserDto userDto) {
        return userService.saveOrUpdate(userDto);
    }
}
