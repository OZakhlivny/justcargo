package com.olegzakhlivnyy.justcargo.services.interfaces;

import com.olegzakhlivnyy.justcargo.entities.UserClass;
import com.olegzakhlivnyy.justcargo.entities.dtos.UserClassDto;

import java.util.List;

public interface UserClassService {
    List<UserClassDto> findAll();

    UserClassDto findById(Long id);

    UserClass findEntityById(Long id);

    UserClassDto findOneByName(String name);
}
