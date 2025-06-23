package com.jzajas.chat.Controllers;


import com.jzajas.chat.DTO.Input.ChatRoomCreationDTO;
import com.jzajas.chat.DTO.Output.ChatRoomShowDTO;
import com.jzajas.chat.Entities.ChatRoom;
import com.jzajas.chat.Services.Interfaces.ChatRoomServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

//    @MessageMapping("/chat.sendMessage")
//    @SendTo("/topic/public")
//    public Message sendMessage(@Payload Message message) {
//        return message;
//    }
//
//    @MessageMapping("/chat.addUser")
//    @SendTo("/topic/public")
//    public Message addUser(@Payload Message message, SimpMessageHeaderAccessor accessor) {
////        this adds name in web socket session
//        accessor.getSessionAttributes().put("username", message.getSender());
//        return message;
//    }

    private final ChatRoomServiceInterface chatRoomService;


    @PostMapping("/create")
    public ResponseEntity<ChatRoom> createNewChatRoom(@RequestBody @Valid ChatRoomCreationDTO dto) {
        ChatRoom room = chatRoomService.createNewChatRoom(dto);

        return new ResponseEntity<>(room, HttpStatus.CREATED);
    }

    @GetMapping("/room")
    public ResponseEntity<ChatRoomShowDTO> getChatRoom(Long id) {
        ChatRoomShowDTO dto = chatRoomService.getCharRoomById(id);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ChatRoomShowDTO>> getAllRooms(Long id) {
        List<ChatRoomShowDTO> dtos = chatRoomService.getAllRoomsForUser(id);

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ChatRoom> updateRoomInfor(@RequestBody @Valid ChatRoomCreationDTO dto, Long id) {
        ChatRoom updatedRoom = chatRoomService.updateChatRoom(dto, id);

        return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> deleteRoom(Long id) {
        chatRoomService.deleteChatRoomById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
