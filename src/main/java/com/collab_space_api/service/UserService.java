package com.collab_space_api.service;

import com.collab_space_api.dto.UserRequestDTO;
import com.collab_space_api.entity.UserEntity;
import com.collab_space_api.exception.UserNotFoundException;
import com.collab_space_api.mapper.UserMapper;
import com.collab_space_api.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private static final String USER_NOT_FOUND = "Usuário não encontrado com ID: ";
    private static final String USER_NOT_FOUND_EMAIL = "Usuário não encontrado com email: ";
    private static final String USER_NOT_FOUND_NAME = "Usuário não encontrado com nome: ";
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserRequestDTO createUser(UserRequestDTO request) {
        UserEntity entity = userMapper.toEntity(request);
        return userMapper.toResponseDTO(userRepository.save(entity));
    }

    public UserRequestDTO getUserById(String id) {
        return userMapper.toResponseDTO(findUserOrThrow(id));
    }

    public UserRequestDTO updateUser(String id, UserRequestDTO request) {
        UserEntity entity = findUserOrThrow(id);
        userMapper.updateEntity(entity, request);
        return userMapper.toResponseDTO(userRepository.save(entity));
    }

    public void deleteUserById(String id) {
        findUserOrThrow(id);
        userRepository.deleteById(id);
    }

    public UserRequestDTO getUserByEmail(String email) {
        return userMapper.toResponseDTO(userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_EMAIL + email)));
    }

    public UserRequestDTO getUserByName(String name) {
        return userMapper.toResponseDTO(userRepository.findByName(name)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_NAME + name)));
    }

    private UserEntity findUserOrThrow(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND + id));
    }

    public List<UserRequestDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toResponseDTO)
                .toList();
    }
}