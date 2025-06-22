package com.jzajas.chat.Services.Implementations;

import com.jzajas.chat.DTO.Input.MessageCreationDTO;
import com.jzajas.chat.DTO.Output.MessageShowDTO;
import com.jzajas.chat.Entities.Message;
import com.jzajas.chat.Repositories.MessageRepository;
import com.jzajas.chat.Services.Interfaces.MessageServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageServiceInterface {

    private final MessageRepository messageRepository;


    @Override
    public Message createNewMessage(MessageCreationDTO dto) {
        Message message = createMessageFromDTO(dto);
        return messageRepository.save(message);
    }

//    TODO create mapping in message model to return a dto from repository and use it here
    @Override
    public MessageShowDTO getMessageByID(Long id) {
//        return messageRepository.findById(id);
        return new MessageShowDTO();
    }

//    TODO create a new exception for not finding message by id
    @Override
    public Message updateMessage(MessageCreationDTO dto, Long id) {
        Message existing = messageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Message not found"));

        Message newMessage = createNewMessage(dto);
        newMessage.setUpdated(true);
        return newMessage;
    }

    @Override
    public void deleteMessageById(Long id) {
        messageRepository.deleteById(id);
    }

//    TODO implement this helper function
    private Message createMessageFromDTO(MessageCreationDTO dto) {
        Message message = new Message();

        return message;
    }
}
