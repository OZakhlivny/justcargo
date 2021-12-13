package com.olegzakhlivnyy.justcargo.controllers;

import com.olegzakhlivnyy.justcargo.controllers.interfaces.UserClassController;
import com.olegzakhlivnyy.justcargo.entities.dtos.UserClassDto;
import com.olegzakhlivnyy.justcargo.services.interfaces.UserClassService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserClassControllerImpl implements UserClassController {

    private final UserClassService userClassService;

    @Override
    public UserClassDto getById(Long id) {
        return userClassService.findById(id);
    }

    @Override
    public List<UserClassDto> getAllUserClasses() {
        return userClassService.findAll();
    }
}
