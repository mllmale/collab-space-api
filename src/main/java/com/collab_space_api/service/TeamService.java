package com.collab_space_api.service;

import com.collab_space_api.dto.TeamRequestDTO;
import com.collab_space_api.dto.TeamResponseDTO;
import com.collab_space_api.entity.TeamEntity;
import com.collab_space_api.mapper.TeamMapper;
import com.collab_space_api.repository.TeamRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class TeamService {
    private static final String TEAM_NOT_FOUND = "Team não encontrada com ID: ";

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public TeamResponseDTO createTeam(TeamRequestDTO request) {
        TeamEntity entity = teamMapper.toEntity(request);
        return teamMapper.toResponseDTO(teamRepository.save(entity));
    }

    public TeamResponseDTO getById(String id) {
        return teamMapper.toResponseDTO(findTeamOrThrow(id));
    }

    public TeamResponseDTO updateTeam(String id, TeamRequestDTO request) {
        TeamEntity entity = findTeamOrThrow(id);
        teamMapper.updateEntity(entity, request);
        return teamMapper.toResponseDTO(teamRepository.save(entity));
    }

    public void deleteById(String id) {
        findTeamOrThrow(id);
        teamRepository.deleteById(id);
    }

    private TeamEntity findTeamOrThrow(String id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(TEAM_NOT_FOUND + id));
    }


}
