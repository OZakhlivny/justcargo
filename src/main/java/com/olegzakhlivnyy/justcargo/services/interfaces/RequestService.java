package com.olegzakhlivnyy.justcargo.services.interfaces;

import com.olegzakhlivnyy.justcargo.entities.Request;
import com.olegzakhlivnyy.justcargo.entities.dtos.RequestDto;

import java.util.List;

public interface RequestService {
    RequestDto findById(Long id);

    Request findEntityById(Long id);

    List<RequestDto> findByDeparture(String departure);

    List<RequestDto> findByDestination(String destination);

    List<RequestDto> findByOwnerId(Long id);

    RequestDto saveOrUpdate(RequestDto requestDto);

    void deleteById(Long id);
}
