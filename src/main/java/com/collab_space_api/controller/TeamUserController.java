package com.collab_space_api.controller;

import com.collab_space_api.dto.TeamUserRequestDTO;
import com.collab_space_api.dto.TeamUserResponseDTO;
import com.collab_space_api.service.TeamUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/team-users")
@RequiredArgsConstructor
@Validated  // Para garantir validação dos parâmetros de entrada
public class TeamUserController {

    private final TeamUserService teamUserService;

    // Método para buscar um TeamUser por ID
    @GetMapping("/{id}")
    public ResponseEntity<TeamUserResponseDTO> getTeamUserById(@PathVariable String id) {
        TeamUserResponseDTO teamUser = teamUserService.getTeamUserById(id);
        return ResponseEntity.ok(teamUser);
    }

    // Método para criar um novo TeamUser
    @PostMapping
    public ResponseEntity<TeamUserResponseDTO> createTeamUser(@Valid @RequestBody TeamUserRequestDTO request) {
        TeamUserResponseDTO createdTeamUser = teamUserService.createTeamUser(request);
        return ResponseEntity.status(201).body(createdTeamUser); // Retorna HTTP 201 Created
    }

    // Método para deletar um TeamUser
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeamUser(@PathVariable String id) {
        teamUserService.deleteById(id);
        return ResponseEntity.noContent().build(); // Retorna HTTP 204 No Content
    }

    // Método para atualizar um TeamUser
    @PutMapping("/{id}")
    public ResponseEntity<TeamUserResponseDTO> updateTeamUser(@PathVariable String id, @Valid @RequestBody TeamUserResponseDTO request) {
        TeamUserResponseDTO updatedTeamUser = teamUserService.updateTeamUser(id, request);
        return ResponseEntity.ok(updatedTeamUser); // Retorna HTTP 200 OK
    }

    // Método para buscar todos os TeamUsers de um time específico
    @GetMapping("/team/{teamId}")
    public ResponseEntity<List<TeamUserResponseDTO>> getTeamUsersByTeamId(@PathVariable String teamId) {
        List<TeamUserResponseDTO> teamUsers = teamUserService.getTeamUsersByTeamId(teamId);
        return ResponseEntity.ok(teamUsers);
    }
}
