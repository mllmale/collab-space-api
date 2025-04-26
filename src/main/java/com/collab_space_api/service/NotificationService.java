package com.collab_space_api.service;

import com.collab_space_api.entity.NotificationEntity;
import com.collab_space_api.repository.NotificationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class NotificationService {

    private final NotificationRepository notificationRepository;

    // CREATE
    public NotificationEntity createNotification(NotificationEntity notification) {
        notification.setRead(false);
        return notificationRepository.save(notification);
    }

    // READ - buscar por ID
    public NotificationEntity getById(String id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificação não encontrada"));
    }

    // READ - buscar todas de um usuário
    public List<NotificationEntity> getByUserId(String userId) {
        return notificationRepository.findByUserId(userId);
    }

    // UPDATE - marcar como lida
    public NotificationEntity markAsRead(String id) {
        NotificationEntity notification = getById(id);
        notification.setRead(true);
        return notificationRepository.save(notification);
    }

    // DELETE
    public void deleteById(String id) {
        notificationRepository.deleteById(id);
    }

    public List<NotificationEntity> getUnreadByUserId(String userId) {
        return notificationRepository.findByUserIdAndRead(userId, false);
    }

    public List<NotificationEntity> getByUserIdAndDate(String userId, String createdAt) {
        return notificationRepository.findByUserIdAndCreatedAt(userId, createdAt);
    }

    public List<NotificationEntity> getUnreadByDate(String date) {
        return notificationRepository.findByReadAndCreatedAt(false, date);
    }
}

