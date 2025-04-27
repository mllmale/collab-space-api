package com.collab_space_api.service;

import com.collab_space_api.dto.TaskRequestDTO;
import com.collab_space_api.dto.TaskResponseDTO;
import com.collab_space_api.entity.TaskEntity;
import com.collab_space_api.exception.TaskNotFoundException;
import com.collab_space_api.mapper.TaskMapper;
import com.collab_space_api.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {
    private static final String TASK_NOT_FOUND = "Task não encontrada com ID: ";
    
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskRequestDTO createTask(TaskRequestDTO request) {
        TaskEntity entity = taskMapper.toEntity(request);
        TaskEntity savedEntity = taskRepository.save(entity);
        return taskMapper.toResponseDTO(savedEntity);
    }

    public TaskRequestDTO getById(String id) {
        TaskEntity entity = findTaskOrThrow(id);
        return taskMapper.toResponseDTO(entity);
    }

    public TaskRequestDTO updateTask(String id, TaskRequestDTO request) {
        TaskEntity entity = findTaskOrThrow(id);
        taskMapper.updateEntity(entity, request);
        TaskEntity updatedEntity = taskRepository.save(entity);
        return taskMapper.toResponseDTO(updatedEntity);
    }

    public void deleteById(String id) {
        findTaskOrThrow(id); // Verifica se a task existe antes de deletar
        taskRepository.deleteById(id);
    }

    private TaskEntity findTaskOrThrow(String id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(TASK_NOT_FOUND + id));
    }
}