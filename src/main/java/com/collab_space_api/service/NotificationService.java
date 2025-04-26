package com.collab_space_api.service;

import com.collab_space_api.dto.NotificationRequestDTO;
import com.collab_space_api.dto.NotificationResponseDTO;
import com.collab_space_api.dto.NotificationUpdateDTO;
import com.collab_space_api.entity.NotificationEntity;
import com.collab_space_api.repository.NotificationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class NotificationService {

    private final NotificationRepository notificationRepository;

    // CREATE
    public NotificationResponseDTO createNotification(NotificationRequestDTO dto) {
        NotificationEntity entity = new NotificationEntity();
        entity.setUserId(dto.getUserId());
        entity.setContent(dto.getContent());
        entity.setRead(false);
        entity.setCreatedAt(LocalDateTime.now().toString());

        return toDTO(notificationRepository.save(entity));
    }

    // READ
    public NotificationResponseDTO getById(String id) {
        return toDTO(notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificação não encontrada")));
    }

    public List<NotificationResponseDTO> getByUserId(String userId) {
        return notificationRepository.findByUserId(userId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<NotificationResponseDTO> getUnreadByUserId(String userId) {
        return notificationRepository.findByUserIdAndRead(userId, false)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<NotificationResponseDTO> getByUserIdAndDate(String userId, String createdAt) {
        return notificationRepository.findByUserIdAndCreatedAt(userId, createdAt)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<NotificationResponseDTO> getUnreadByDate(String date) {
        return notificationRepository.findByReadAndCreatedAt(false, date)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // UPDATE - marcar como lida
    public NotificationResponseDTO updateReadStatus(String id, NotificationUpdateDTO dto) {
        NotificationEntity notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificação não encontrada"));

        notification.setRead(dto.getRead());
        return toDTO(notificationRepository.save(notification));
    }

    // DELETE
    public void deleteById(String id) {
        notificationRepository.deleteById(id);
    }

    // Conversor
    private NotificationResponseDTO toDTO(NotificationEntity entity) {
        return new NotificationResponseDTO(
                entity.getId(),
                entity.getUserId(),
                entity.getContent(),
                entity.isRead(),
                entity.getCreatedAt()
        );
    }
}
