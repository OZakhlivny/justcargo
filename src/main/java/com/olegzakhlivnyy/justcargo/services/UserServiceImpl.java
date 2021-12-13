package com.olegzakhlivnyy.justcargo.services;

import com.olegzakhlivnyy.justcargo.entities.User;
import com.olegzakhlivnyy.justcargo.entities.dtos.UserDto;
import com.olegzakhlivnyy.justcargo.exceptions.ResourceNotFoundException;
import com.olegzakhlivnyy.justcargo.repositories.UserRepository;
import com.olegzakhlivnyy.justcargo.services.interfaces.UserClassService;
import com.olegzakhlivnyy.justcargo.services.interfaces.UserService;
import com.olegzakhlivnyy.justcargo.services.interfaces.UserTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserClassService userClassService;
    private final UserTypeService userTypeService;

    @Override
    public UserDto findById(Long id) {
        return new UserDto(userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Пользователь с id = %d не найден", id))));
    }

    @Override
    public User findEntityById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Пользователь с id = %d не найден", id)));
    }

    @Override
    public UserDto findByLogin(String login) {
        return new UserDto(userRepository.findByLogin(login)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Пользователь с логином = %s не найден", login))));
    }

    @Override
    public UserDto saveOrUpdate(UserDto userDto) {
        User user;
        if(userDto.getId() == null) user = new User();
        else user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Пользователь с id = %d не найден", userDto.getId())));

        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPhone(userDto.getPhone());
        user.setEmail(userDto.getEmail());
        user.setUserType(userTypeService.findEntityById(userDto.getUserTypeId()));
        user.setUserClass(userClassService.findEntityById(userDto.getUserClassId()));

        return new UserDto(userRepository.save(user));
    }

    @Override
    public boolean isPresent(String login) {
        return userRepository.existsByLogin(login);
    }
}
