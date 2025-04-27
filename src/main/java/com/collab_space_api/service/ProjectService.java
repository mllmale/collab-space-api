package com.collab_space_api.service;
import com.collab_space_api.dto.ProjectRequestDTO;
import com.collab_space_api.dto.ProjectResponseDTO;
import com.collab_space_api.entity.ProjectEntity;
import com.collab_space_api.repository.ProjectRepository;
import com.collab_space_api.exception.ProjectNotFoundException;
import com.collab_space_api.mapper.ProjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectResponseDTO createProject(ProjectRequestDTO request) {
        ProjectEntity entity = projectMapper.toEntity(request);
        ProjectEntity savedEntity = projectRepository.save(entity);
        return projectMapper.toResponseDTO(savedEntity);
    }

    public ProjectResponseDTO updateProject(String id, ProjectRequestDTO request) {
        ProjectEntity entity = findProjectOrThrow(id);
        projectMapper.updateEntityFromRequest(entity, request);
        return projectMapper.toResponseDTO(projectRepository.save(entity));
    }

    public ProjectResponseDTO getById(String id) {
        return projectMapper.toResponseDTO(findProjectOrThrow(id));
    }

    private ProjectEntity findProjectOrThrow(String id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Projeto não encontrado com ID: " + id));
    }
}