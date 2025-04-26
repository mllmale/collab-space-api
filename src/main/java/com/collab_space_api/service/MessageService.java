package com.collab_space_api.service;

import com.collab_space_api.entity.MessageEntity;
import com.collab_space_api.repository.MessageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MessageService {
     private final MessageRepository messageRepository;

     // CREATE
     public MessageEntity createMessage(MessageEntity message) {
         return messageRepository.save(message);
     }

     // READ - buscar por ID
     public MessageEntity getById(String id) {
         return messageRepository.findById(id)
                 .orElseThrow(() -> new RuntimeException("Mensagem não encontrada"));
     }

     // READ - buscar todas de um usuário
     public List<MessageEntity> getByUserId(String senderId) {
         return messageRepository.findBySenderId(senderId);
     }
    // READ - buscar todas de um projeto
    public List<MessageEntity> getByProjectId(String projectId) {
        return messageRepository.findByProjectId(projectId);
    }
    // READ - buscar todas de um time
    public List<MessageEntity> getByTeamId(String teamId) {
        return messageRepository.findByTeamId(teamId);
    }

     // UPDATE
     public MessageEntity updateMessage(MessageEntity message) {
         return messageRepository.save(message);
     }

     // DELETE
     public void deleteById(String id) {
         messageRepository.deleteById(id);
     }

     public List<MessageEntity> getBySenderIdAndProjectId(String senderId, String projectId) {
         return messageRepository.findBySenderIdAndProjectId(senderId, projectId);
     }

     public List<MessageEntity> getBySenderIdAndTeamId(String senderId, String teamId) {
         return messageRepository.findBySenderIdAndTeamId(senderId, teamId);
     }

     public List<MessageEntity> getBySenderIdAndContent(String senderId, String content) {
         return messageRepository.findBySenderIdAndContent(senderId, content);
     }

     public List<MessageEntity> getBySenderIdAndSentAt(String senderId, String sentAt) {
         return messageRepository.findBySenderIdAndSentAt(senderId, sentAt);
     }

     public List<MessageEntity> getByProjectIdAndTeamId(String projectId, String teamId) {
         return messageRepository.findByProjectIdAndTeamId(projectId, teamId);
     }

     public List<MessageEntity> getByProjectIdAndContent(String projectId, String content) {
         return messageRepository.findByProjectIdAndContent(projectId, content);
     }

}
