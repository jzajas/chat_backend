package com.jzajas.chat.Services.Interfaces;


import com.jzajas.chat.DTO.Input.MessageCreationDTO;
import com.jzajas.chat.DTO.Output.MessageShowDTO;
import com.jzajas.chat.Entities.Message;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MessageServiceInterface {

    @Transactional
    Message createNewMessage(MessageCreationDTO dto);

    @Transactional(readOnly = true)
    MessageShowDTO getMessageByID(Long id);

//    TODO add reading messages for all conditions -> user / room / else
//    List<MessageShowDTO> getAllMessages();

    @Transactional
    Message updateMessage(MessageCreationDTO dto, Long id);

    @Transactional
    void deleteMessageById(Long id);
}
