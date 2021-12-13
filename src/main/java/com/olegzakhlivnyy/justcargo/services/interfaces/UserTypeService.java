package com.olegzakhlivnyy.justcargo.services.interfaces;

import com.olegzakhlivnyy.justcargo.entities.UserType;
import com.olegzakhlivnyy.justcargo.entities.dtos.UserTypeDto;

import java.util.List;

public interface UserTypeService {
    List<UserTypeDto> findAll();

    UserTypeDto findById(Long id);

    UserType findEntityById(Long id);

    UserTypeDto findOneByName(String name);
}
