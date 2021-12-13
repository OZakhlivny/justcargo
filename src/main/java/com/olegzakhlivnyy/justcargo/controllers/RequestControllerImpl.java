package com.olegzakhlivnyy.justcargo.controllers;

import com.olegzakhlivnyy.justcargo.controllers.interfaces.RequestController;
import com.olegzakhlivnyy.justcargo.entities.dtos.RequestDto;
import com.olegzakhlivnyy.justcargo.services.interfaces.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RequestControllerImpl implements RequestController {

    private final RequestService requestService;

    @Override
    public RequestDto getById(Long id) {
        return requestService.findById(id);
    }

    @Override
    public List<RequestDto> getAllByOwnerId(Long id) {
        return requestService.findByOwnerId(id);
    }

    @Override
    public List<RequestDto> getAllByDeparture(String departure) {
        return requestService.findByDeparture(departure);
    }

    @Override
    public List<RequestDto> getAllByDestination(String destination) {
        return requestService.findByDestination(destination);
    }

    @Override
    public RequestDto saveOrUpdate(RequestDto requestDto) {
        return requestService.saveOrUpdate(requestDto);
    }

    @Override
    public void deleteRequestById(Long id) {
        requestService.deleteById(id);
    }
}
