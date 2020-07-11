package com.xml.soap;

import com.xml.RentCar.wsdl.*;
import com.xml.dto.MessageDto;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.io.IOException;
import java.time.LocalDateTime;

public class MessageClient extends WebServiceGatewaySupport {

    public MessageResponse postMessage(MessageDto messageDto) {

        MessageRequest request = new MessageRequest();
        request.setMessage(messageDto.getMessage());
        request.setMessageDate(LocalDateTime.now().toString());
        request.setRecieverId(messageDto.getReceiver().getId());
        request.setSenderId(1L);

        MessageResponse response = (MessageResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws/message-service-schema", request,
                        new SoapActionCallback("http://localhost:8088/ws/message-service-schema/messageRequest"));

        return response;
    }

    public GetMessagesResponse getMessages() throws IOException {

        GetMessagesRequest request = new GetMessagesRequest();
        request.setSenderId(1L);

        GetMessagesResponse response = (GetMessagesResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws/message-service-schema", request,
                        new SoapActionCallback("http://localhost:8088/ws/message-service-schema/getMessagesRequest"));

        return response;

    }
}
