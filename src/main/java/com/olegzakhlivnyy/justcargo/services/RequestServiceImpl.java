package com.olegzakhlivnyy.justcargo.services;

import com.olegzakhlivnyy.justcargo.entities.Request;
import com.olegzakhlivnyy.justcargo.entities.dtos.RequestDto;
import com.olegzakhlivnyy.justcargo.exceptions.ResourceNotFoundException;
import com.olegzakhlivnyy.justcargo.repositories.RequestRepository;
import com.olegzakhlivnyy.justcargo.services.interfaces.RequestService;
import com.olegzakhlivnyy.justcargo.services.interfaces.RequestStatusService;
import com.olegzakhlivnyy.justcargo.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;
    private final UserService userService;
    private final RequestStatusService requestStatusService;

    @Override
    public RequestDto findById(Long id) {
        return new RequestDto(requestRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("Заявка с id = %d не найдена", id))));
    }

    @Override
    public Request findEntityById(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("Заявка с id = %d не найдена", id)));
    }

    @Override
    public List<RequestDto> findByDeparture(String departure) {
        return requestRepository.findByDeparture(departure).stream().map(RequestDto::new).collect(Collectors.toList());
    }

    @Override
    public List<RequestDto> findByDestination(String destination) {
        return requestRepository.findByDestination(destination).stream().map(RequestDto::new).collect(Collectors.toList());
    }

    @Override
    public List<RequestDto> findByOwnerId(Long id) {
        return requestRepository.findByOwnerId(id).stream().map(RequestDto::new).collect(Collectors.toList());
    }

    @Override
    public RequestDto saveOrUpdate(RequestDto requestDto) {
        Request request;
        if(requestDto.getId() == null) request = new Request();
        else request = requestRepository.findById(requestDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Заявка с id = %d не найдена", requestDto.getId())));

        request.setDeparture(requestDto.getDeparture());
        request.setDestination(requestDto.getDestination());
        request.setRequestTime(requestDto.getRequestTime());
        request.setDeliveryTime(requestDto.getDeliveryTime());
        request.setCost(requestDto.getCost());
        request.setDescription(requestDto.getDescription());
        request.setHeight(requestDto.getHeight());
        request.setLength(requestDto.getLength());
        request.setWidth(requestDto.getWidth());
        request.setWeight(requestDto.getWeight());
        request.setShortInfo(requestDto.getShortInfo());
        request.setPackagesNumber(requestDto.getPackagesNumber());
        request.setOwner(userService.findEntityById(requestDto.getOwnerId()));
        request.setStatus(requestStatusService.findEntityById(requestDto.getStatusId()));

        return new RequestDto(requestRepository.save(request));
    }

    @Override
    public void deleteById(Long id) {
        requestRepository.deleteById(id);
    }
}
