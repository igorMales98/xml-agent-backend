package com.xml.service;

import com.xml.RentCar.wsdl.GetMessagesResponse;
import com.xml.RentCar.wsdl.MessageResponse;
import com.xml.dto.MessageDto;
import com.xml.model.Message;
import com.xml.model.User;

import java.util.List;

public interface MessageService {
    List<User> getReservedCustomers(Long agentId);

    List<Message> getMessages(Long agentId, Long customerId);

    void sendMessage(MessageDto messageDto, MessageResponse response);

    void saveMessagesFromServer(GetMessagesResponse getMessagesResponse);
}
