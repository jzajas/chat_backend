package com.jzajas.chat.Services.Implementations;

import com.jzajas.chat.DTO.Input.ChatRoomCreationDTO;
import com.jzajas.chat.DTO.Output.ChatRoomShowDTO;
import com.jzajas.chat.Entities.ChatRoom;
import com.jzajas.chat.Repositories.ChatRoomRepository;
import com.jzajas.chat.Services.Interfaces.ChatRoomServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomServiceInterface {

    private final ChatRoomRepository chatRoomRepository;


    @Override
    public ChatRoom createNewChatRoom(ChatRoomCreationDTO dto) {
        return createChatFromFromDTO(dto);
    }

//    TODO implement this to return DTO from repository
    @Override
    public ChatRoomShowDTO getCharRoomById(Long id) {
//        return chatRoomRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Room Not Found"));
        return new ChatRoomShowDTO();
    }

//    TODO implement this to return list of DTO from repository
    @Override
    public List<ChatRoomShowDTO> getAllRoomsForUser(Long id) {
        return List.of();
    }

    @Override
    public ChatRoom updateChatRoom(ChatRoomCreationDTO dto, Long id) {
        ChatRoom existing = chatRoomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Room Not Found"));

        return createChatFromFromDTO(dto);
    }

    @Override
    public void deleteChatRoomById(Long id) {
        chatRoomRepository.deleteById(id);
    }

//    TODO implement this helper function
    private ChatRoom createChatFromFromDTO(ChatRoomCreationDTO dto) {

        return new ChatRoom();
    }
}
