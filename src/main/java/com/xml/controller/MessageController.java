package com.xml.controller;

import com.xml.dto.CommentDto;
import com.xml.dto.MessageDto;
import com.xml.dto.UserDto;
import com.xml.mapper.MessageDtoMapper;
import com.xml.mapper.UserDtoMapper;
import com.xml.model.Message;
import com.xml.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/message")
public class MessageController
{
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserDtoMapper userDtoMapper;
    @Autowired
    private MessageDtoMapper messageDtoMapper;

    @GetMapping(value = "/getReservedCustomers/{agentId}")
    public ResponseEntity<?> getReservedCustomers(@PathVariable("agentId") Long agentId) {
        try {
            List<UserDto> userDtos = this.messageService.getReservedCustomers(agentId).stream()
                    .map(userDtoMapper::toDto).collect(Collectors.toList());
            return new ResponseEntity<>(userDtos, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/{agentId}/{customerId}")
    public ResponseEntity<?> getMessages(@PathVariable("agentId") Long agentId,@PathVariable("customerId") Long customerId) {
        try {
            List<MessageDto> messageDtos = this.messageService.getMessages(agentId,customerId).stream()
                    .map(messageDtoMapper::toDto).collect(Collectors.toList());
            return new ResponseEntity<>(messageDtos, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "")
    public ResponseEntity<?> sendMessage(@RequestBody MessageDto messageDto) {
        try {
            //TODO: sender-senderId
            this.messageService.sendMessage(messageDto);
            System.out.println("usao1");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("usao2");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
