package com.collab_space_api.repository;

import com.collab_space_api.entity.MessageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends MongoRepository<MessageEntity, String> {
    List<MessageEntity> findByProjectId(String projectId);
    List<MessageEntity> findByTeamId(String teamId);
    List<MessageEntity> findBySenderId(String senderId);
    List<MessageEntity> findByContent(String content);
    List<MessageEntity> findBySentAt(String sentAt);
    List<MessageEntity> findBySenderIdAndProjectId(String senderId, String projectId);
    List<MessageEntity> findBySenderIdAndTeamId(String senderId, String teamId);
    List<MessageEntity> findBySenderIdAndContent(String senderId, String content);
    List<MessageEntity> findBySenderIdAndSentAt(String senderId, String sentAt);
    List<MessageEntity> findByProjectIdAndTeamId(String projectId, String teamId);
    List<MessageEntity> findByProjectIdAndContent(String projectId, String content);
}
