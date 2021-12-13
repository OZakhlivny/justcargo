package com.olegzakhlivnyy.justcargo.controllers;

import com.olegzakhlivnyy.justcargo.controllers.interfaces.UserTypeController;
import com.olegzakhlivnyy.justcargo.entities.dtos.UserTypeDto;
import com.olegzakhlivnyy.justcargo.services.interfaces.UserTypeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserTypeControllerImpl implements UserTypeController {

    private final UserTypeService userTypeService;

    @Override
    public UserTypeDto getById(Long id) {
        return userTypeService.findById(id);
    }

    @Override
    public List<UserTypeDto> getAllUserTypes() {
        return userTypeService.findAll();
    }
}
