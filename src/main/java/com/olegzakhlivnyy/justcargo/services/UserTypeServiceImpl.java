package com.olegzakhlivnyy.justcargo.services;

import com.olegzakhlivnyy.justcargo.entities.UserType;
import com.olegzakhlivnyy.justcargo.entities.dtos.UserTypeDto;
import com.olegzakhlivnyy.justcargo.exceptions.ResourceNotFoundException;
import com.olegzakhlivnyy.justcargo.repositories.UserTypeRepository;
import com.olegzakhlivnyy.justcargo.services.interfaces.UserTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserTypeServiceImpl implements UserTypeService {
    private final UserTypeRepository userTypeRepository;

    @Override
    public List<UserTypeDto> findAll() {
        return userTypeRepository.findAll().stream().map(UserTypeDto::new).collect(Collectors.toList());
    }

    @Override
    public UserTypeDto findById(Long id) {
        return new UserTypeDto(userTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Класс пользователя с id = %d не найден", id))));
    }

    @Override
    public UserType findEntityById(Long id) {
        return userTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Класс пользователя с id = %d не найден", id)));
    }

    @Override
    public UserTypeDto findOneByName(String name) {
        return new UserTypeDto(userTypeRepository.findOneByName(name)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Класс пользователя с наименованием = \"%s\" не найден", name))));

    }
}
