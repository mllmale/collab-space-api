package com.collab_space_api.repository;

import com.collab_space_api.entity.NotificationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<NotificationEntity, String> {
    List<NotificationEntity> findByUserId(String userId);
    List<NotificationEntity> findByRead(boolean read);
    List<NotificationEntity> findByCreatedAt(String createdAt);
    List<NotificationEntity> findByUserIdAndRead(String userId, boolean read);
    List<NotificationEntity> findByUserIdAndCreatedAt(String userId, String createdAt);
    List<NotificationEntity> findByReadAndCreatedAt(boolean read, String createdAt);

}
