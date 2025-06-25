package com.jzajas.chat.Controllers;

import com.jzajas.chat.Entities.Message;
import lombok.AllArgsConstructor;
import org.springframework.messaging.core.AbstractDestinationResolvingMessagingTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class WebSocketController {

    private final SimpMessagingTemplate simpMessagingTemplate;
//    TODO securing endpoints:
//    ResourceServerConfigurerAdapter
//        WebSecurityConfigurerAdapter

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message send(Message message) {
        return message;
    }


    @MessageMapping("/news")
    public void broadcastNews(@Payload String message) {
        this.simpMessagingTemplate.convertAndSend("/topic/news", message)
    }

}
