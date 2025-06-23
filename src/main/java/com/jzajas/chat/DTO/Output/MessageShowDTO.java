package com.jzajas.chat.DTO.Output;

import com.jzajas.chat.Entities.ChatRoom;
import com.jzajas.chat.Entities.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageShowDTO {

    @NotNull
    private String message;

    @NotNull
    private User sender;

    @NotNull
    private ChatRoom ChatRoom;

    @NotNull
    private Date createdAt;

    @NotNull
    private Boolean updated;
}
