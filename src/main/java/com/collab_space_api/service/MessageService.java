package com.collab_space_api.service;

import com.collab_space_api.dto.MessageRequestDTO;
import com.collab_space_api.dto.MessageResponseDTO;
import com.collab_space_api.entity.MessageEntity;
import com.collab_space_api.mapper.MessageMapper;
import com.collab_space_api.repository.MessageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MessageService {
    private static final String MESSAGE_NOT_FOUND = "Mensagem não encontrada";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public MessageResponseDTO createMessage(MessageRequestDTO request) {
        MessageEntity entity = toEntity(request);
        entity.setSentAt(LocalDateTime.now().format(DATE_FORMATTER));
        return messageMapper.ToResponseDTO(messageRepository.save(entity));
    }

    public MessageResponseDTO getById(String id) {
        return messageMapper.ToResponseDTO(findMessageOrThrow(id));
    }

    public List<MessageResponseDTO> getByUserId(String senderId) {
        return messageRepository.findBySenderId(senderId).stream()
                .map(messageMapper::ToResponseDTO)
                .toList();
    }

    public MessageResponseDTO updateMessage(String id, MessageRequestDTO request) {
        MessageEntity entity = findMessageOrThrow(id);
        updateEntityFromRequest(entity, request);
        return messageMapper.ToResponseDTO(messageRepository.save(entity));
    }

    public void deleteById(String id) {
        messageRepository.deleteById(id);
    }

    private MessageEntity findMessageOrThrow(String id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException(MESSAGE_NOT_FOUND));
    }

    private MessageEntity toEntity(MessageRequestDTO request) {
        MessageEntity entity = new MessageEntity();
        updateEntityFromRequest(entity, request);
        return entity;
    }

    private void updateEntityFromRequest(MessageEntity entity, MessageRequestDTO request) {
        entity.setContent(request.getContent());
        entity.setProjectId(request.getProjectId());
        entity.setTeamId(request.getTeamId());
        entity.setSenderId(request.getSenderId());
    }

    public static class MessageNotFoundException extends RuntimeException {
        public MessageNotFoundException(String message) {
            super(message);
        }
    }
}