package com.olegzakhlivnyy.justcargo.controllers;

import com.olegzakhlivnyy.justcargo.controllers.interfaces.RequestStatusController;
import com.olegzakhlivnyy.justcargo.entities.dtos.RequestStatusDto;
import com.olegzakhlivnyy.justcargo.services.interfaces.RequestStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RequestStatusControllerImpl implements RequestStatusController {

    private final RequestStatusService requestStatusService;

    @Override
    public RequestStatusDto getById(Long id) {
        return requestStatusService.findById(id);
    }

    @Override
    public List<RequestStatusDto> getAllRequestStatuses() {
        return requestStatusService.findAll();
    }
}
