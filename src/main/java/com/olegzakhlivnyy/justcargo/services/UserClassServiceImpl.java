package com.olegzakhlivnyy.justcargo.services;

import com.olegzakhlivnyy.justcargo.entities.UserClass;
import com.olegzakhlivnyy.justcargo.entities.dtos.UserClassDto;
import com.olegzakhlivnyy.justcargo.exceptions.ResourceNotFoundException;
import com.olegzakhlivnyy.justcargo.repositories.UserClassRepository;
import com.olegzakhlivnyy.justcargo.services.interfaces.UserClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserClassServiceImpl implements UserClassService {

    private final UserClassRepository userClassRepository;

    @Override
    public List<UserClassDto> findAll() {
        return userClassRepository.findAll().stream().map(UserClassDto::new).collect(Collectors.toList());
    }

    @Override
    public UserClassDto findById(Long id) {
        return new UserClassDto(userClassRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Класс пользователя с id = %d не найден", id))));

    }

    @Override
    public UserClass findEntityById(Long id) {
        return userClassRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Класс пользователя с id = %d не найден", id)));

    }

    @Override
    public UserClassDto findOneByName(String name) {
        return new UserClassDto(userClassRepository.findOneByName(name)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Класс пользователя с наименованием = \"%s\" не найден", name))));

    }
}
