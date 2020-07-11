package com.xml.service.impl;

import com.xml.RentCar.wsdl.GetMessagesResponse;
import com.xml.RentCar.wsdl.MessageResponse;
import com.xml.dto.MessageDto;
import com.xml.enummeration.RentRequestStatus;
import com.xml.model.Advertisement;
import com.xml.model.Message;
import com.xml.model.RentRequest;
import com.xml.model.User;
import com.xml.repository.AdvertisementRepository;
import com.xml.repository.MessageRepository;
import com.xml.repository.RentRequestRepository;
import com.xml.repository.UserRepository;
import com.xml.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RentRequestRepository rentRequestRepository;
    @Autowired
    private AdvertisementRepository advertisementRepository;
    @Autowired
    private MessageRepository messageRepository;


    @Override
    public List<User> getReservedCustomers(Long agentId) {
        List<Advertisement> ads = advertisementRepository.getAdvertisementByAdvertiser_id(agentId);
        System.out.println("1");
        List<User> users = new ArrayList<>();
        List<RentRequest> requests = rentRequestRepository.findAll();
        System.out.println("2");
        for (RentRequest req: requests) {
            Set<Advertisement> advertisements = req.getAdvertisementsForRent();
            System.out.println(advertisements.size());
            for (Advertisement ad: advertisements) {
                if (ads.contains(ad)) {
                    if (req.getRentRequestStatus() == RentRequestStatus.RESERVED) {
                        if (!users.contains(userRepository.findOneById(req.getCustomer().getId())))
                            users.add(userRepository.findOneById(req.getCustomer().getId()));
                    }
                }
            }
        }
        System.out.println(users.size());
        for (Message message : this.messageRepository.findAll()) {
            if (message.getSender().getId().equals(agentId)) {
                if (!users.contains(message.getReceiver())) {
                    users.add(message.getReceiver());
                }
            }
            if (message.getReceiver().getId().equals(agentId)) {
                if (!users.contains(message.getSender())) {
                    users.add(message.getSender());
                }
            }
        }
        return users;
    }

    @Override
    public List<Message> getMessages(Long agentId, Long customerId) {
        List<Message> messages = messageRepository.findAllByAgentIdAndCustomerId(agentId,customerId);
        messages.sort(Comparator.comparing(Message::getId));
        return messages;
    }

    @Override
    public void sendMessage(MessageDto messageDto, MessageResponse response) {
        Message message = new Message();
        message.setMessage(messageDto.getMessage());
        message.setReceiver(messageDto.getReceiver());
        message.setSender(userRepository.findOneById(2L));
        message.setMessageDate(LocalDateTime.now());
        message.setRealId(response.getMessageId());
        messageRepository.save(message);
    }

    @Override
    public void saveMessagesFromServer(GetMessagesResponse getMessagesResponse) {

        List<Message> all = this.messageRepository.findAll();
        List<Long> ids = new ArrayList<>();

        for(Message mess : all){
            ids.add(mess.getRealId());
        }

        for(com.xml.RentCar.wsdl.Message messageResp: getMessagesResponse.getMessage()){
            for(Long id : ids){
                if(!ids.contains(messageResp.getId())){
                    Message newMessage = new Message();
                    newMessage.setMessageDate(LocalDateTime.parse(messageResp.getMessageDate()));
                    newMessage.setMessage(messageResp.getMessage());
                    newMessage.setReceiver(this.userRepository.findById(messageResp.getRecieverId()).get());
                    newMessage.setSender(this.userRepository.findById(messageResp.getSenderId()).get());
                    newMessage.setRealId(messageResp.getId());

                    this.messageRepository.save(newMessage);
                    this.messageRepository.flush();

                    break;
                }
            }
        }
    }
}
