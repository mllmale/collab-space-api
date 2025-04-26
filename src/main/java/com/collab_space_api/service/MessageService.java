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
}
