package com.jzajas.chat.Config;


import com.jzajas.chat.Entities.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messageTemplate;

//    TODO this method informs users that user has left the chat
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if (username != null) {
            log.info("user disconnected: {}", username);
            var message = new Message();
//            var message = Message.builder()
////                    .sender(username) -> setting the sender
////                    (here its is String and not Object that is why it doesnt work)
////                    additionally here would be a setter for the message type to Leave
//                    .build();
            messageTemplate.convertAndSend("/topic/public", message);
        }
    }
}
