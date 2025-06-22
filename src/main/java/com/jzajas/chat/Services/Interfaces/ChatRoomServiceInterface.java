package com.jzajas.chat.Services.Interfaces;

import com.jzajas.chat.DTO.Input.ChatRoomCreationDTO;
import com.jzajas.chat.DTO.Output.ChatRoomShowDTO;
import com.jzajas.chat.Entities.ChatRoom;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ChatRoomServiceInterface {

    @Transactional
    ChatRoom createNewChatRoom(ChatRoomCreationDTO dto);

    ChatRoomShowDTO getCharRoomById(Long id);

    List<ChatRoomShowDTO> getAllRoomsForUser(Long id);

    ChatRoom updateChatRoom(ChatRoomCreationDTO dto, Long id);

    void deleteChatRoomById(Long id);
}
