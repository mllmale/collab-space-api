package com.collab_space_api.service;

import com.collab_space_api.dto.TeamUserRequestDTO;
import com.collab_space_api.dto.TeamUserResponseDTO;
import com.collab_space_api.entity.TeamUserEntity;
import com.collab_space_api.exception.TeamUserNotFoundException;
import com.collab_space_api.mapper.TeamUserMapper;
import com.collab_space_api.repository.TeamUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamUserService {
    private static final String TEAM_USER_NOT_FOUND = "TeamUser not found with ID: ";

    private final TeamUserRepository teamUserRepository;
    private final TeamUserMapper teamUserMapper;

    public TeamUserResponseDTO createTeamUser(TeamUserRequestDTO request) {
        TeamUserEntity entity = teamUserMapper.toEntity(request); // Corrigido para usar o DTO correto
        return teamUserMapper.toResponseDTO(teamUserRepository.save(entity));
    }

    public TeamUserResponseDTO getById(String id) {
        return teamUserMapper.toResponseDTO(findTeamUserOrThrow(id));
    }

    public TeamUserResponseDTO updateTeamUser(String id, @Valid TeamUserRequestDTO request) {
        TeamUserEntity entity = findTeamUserOrThrow(id);
        teamUserMapper.updateEntity(entity, request); // Atualiza com dados do DTO
        return teamUserMapper.toResponseDTO(teamUserRepository.save(entity));
    }

    public void deleteById(String id) {
        findTeamUserOrThrow(id);
        teamUserRepository.deleteById(id);
    }

    public TeamUserResponseDTO getTeamUserById(String id) {
        return teamUserMapper.toResponseDTO(findTeamUserOrThrow(id));
    }

    private TeamUserEntity findTeamUserOrThrow(String id) {
        return teamUserRepository.findById(id)
                .orElseThrow(() -> new TeamUserNotFoundException(TEAM_USER_NOT_FOUND + id));
    }

    public List<TeamUserResponseDTO> findAllByTeamId(String teamId) {
        List<TeamUserEntity> teamUsers = teamUserRepository.findAllByTeamId(teamId);
        return teamUsers.stream()
                .map(teamUserMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<TeamUserResponseDTO> getTeamUsersByTeamId(String teamId) {
        List<TeamUserEntity> teamUsers = teamUserRepository.findAllByTeamId(teamId);
        return teamUsers.stream()
                .map(teamUserMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
