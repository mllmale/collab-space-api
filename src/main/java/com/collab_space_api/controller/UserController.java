package com.collab_space_api.controller;

import com.collab_space_api.dto.UserRequestDTO;
import com.collab_space_api.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Criar novo usuário
    @PostMapping
    public ResponseEntity<UserRequestDTO> createUser(@Valid @RequestBody UserRequestDTO request) {
        UserRequestDTO createdUser = userService.createUser(request);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Buscar usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<UserRequestDTO> getUserById(@PathVariable String id) {
        UserRequestDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // Atualizar usuário
    @PutMapping("/{id}")
    public ResponseEntity<UserRequestDTO> updateUser(@PathVariable String id, @Valid @RequestBody UserRequestDTO request) {
        UserRequestDTO updatedUser = userService.updateUser(id, request);
        return ResponseEntity.ok(updatedUser);
    }

    // Deletar usuário por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar usuário por email
    @GetMapping("/email/{email}")
    public ResponseEntity<UserRequestDTO> getUserByEmail(@PathVariable String email) {
        UserRequestDTO user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    // Buscar usuário por nome
    @GetMapping("/name/{name}")
    public ResponseEntity<UserRequestDTO> getUserByName(@PathVariable String name) {
        UserRequestDTO user = userService.getUserByName(name);
        return ResponseEntity.ok(user);
    }

    // Buscar todos os usuários (caso necessário)
    @GetMapping
    public ResponseEntity<List<UserRequestDTO>> getAllUsers() {
        List<UserRequestDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
