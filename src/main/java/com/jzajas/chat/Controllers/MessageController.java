package com.jzajas.chat.Controllers;

import com.jzajas.chat.DTO.Input.MessageCreationDTO;
import com.jzajas.chat.DTO.Output.MessageShowDTO;
import com.jzajas.chat.Entities.Message;
import com.jzajas.chat.Services.Interfaces.MessageServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageServiceInterface messageService;

    @PostMapping("/new")
    public ResponseEntity<Message> createNewMessage(@RequestBody @Valid MessageCreationDTO dto) {
        Message message = messageService.createNewMessage(dto);

        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageShowDTO> getMessageByID(@PathVariable Long id) {
        MessageShowDTO message = messageService.getMessageByID(id);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Message> updateMessageById(@RequestBody @Valid MessageCreationDTO dto, @PathVariable Long id) {
        Message message = messageService.updateMessage(dto, id);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMessageById(@PathVariable Long id) {
        messageService.deleteMessageById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
