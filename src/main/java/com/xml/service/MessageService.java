package com.xml.service;

import com.xml.dto.MessageDto;
import com.xml.model.Message;
import com.xml.model.User;

import java.util.List;

public interface MessageService {
    List<User> getReservedCustomers(Long agentId);

    List<Message> getMessages(Long agentId, Long customerId);

    void sendMessage(MessageDto messageDto);
}
