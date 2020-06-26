package com.xml.dto;

import com.github.rkpunjal.sqlsafe.SQLInjectionSafe;
import com.xml.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class MessageDto {

    private Long id;

    private User sender;

    @NotNull
    private User receiver;

    @NotBlank(message = "Message cannot be empty")
    private @SQLInjectionSafe String message;

    @NotNull
    private LocalDateTime messageDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(LocalDateTime messageDate) {
        this.messageDate = messageDate;
    }
}
