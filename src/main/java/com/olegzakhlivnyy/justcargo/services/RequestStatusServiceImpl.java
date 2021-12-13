package com.olegzakhlivnyy.justcargo.services;

import com.olegzakhlivnyy.justcargo.entities.RequestStatus;
import com.olegzakhlivnyy.justcargo.entities.dtos.RequestStatusDto;
import com.olegzakhlivnyy.justcargo.exceptions.ResourceNotFoundException;
import com.olegzakhlivnyy.justcargo.repositories.RequestStatusRepository;
import com.olegzakhlivnyy.justcargo.services.interfaces.RequestStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RequestStatusServiceImpl implements RequestStatusService {
    private final RequestStatusRepository requestStatusRepository;


    @Override
    public List<RequestStatusDto> findAll() {
        return requestStatusRepository.findAll().stream().map(RequestStatusDto::new).collect(Collectors.toList());
    }

    @Override
    public RequestStatusDto findById(Long id) {
        return new RequestStatusDto(requestStatusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Статус заявки с id = %d не найден", id))));
    }

    @Override
    public RequestStatus findEntityById(Long id) {
        return requestStatusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Статус заявки с id = %d не найден", id)));
    }

    @Override
    public RequestStatusDto findOneByName(String name) {
        return new RequestStatusDto(requestStatusRepository.findOneByName(name)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Статус заявки с наименованием = %s не найден", name))));
    }
}
