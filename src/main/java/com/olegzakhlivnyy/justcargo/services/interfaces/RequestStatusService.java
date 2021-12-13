package com.olegzakhlivnyy.justcargo.services.interfaces;

import com.olegzakhlivnyy.justcargo.entities.RequestStatus;
import com.olegzakhlivnyy.justcargo.entities.dtos.RequestStatusDto;

import java.util.List;

public interface RequestStatusService {
    List<RequestStatusDto> findAll();

    RequestStatusDto findById(Long id);

    RequestStatus findEntityById(Long id);

    RequestStatusDto findOneByName(String name);
}
