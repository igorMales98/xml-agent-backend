package com.xml.service.impl;

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
        return users;
    }

    @Override
    public List<Message> getMessages(Long agentId, Long customerId) {
        List<Message> messages = messageRepository.findAllByAgentIdAndCustomerId(agentId,customerId);
        messages.sort(Comparator.comparing(Message::getId));
        return messages;
    }

    @Override
    public void sendMessage(MessageDto messageDto) {
        Message message = new Message();
        message.setMessage(messageDto.getMessage());
        message.setReceiver(messageDto.getReceiver());
        message.setSender(userRepository.findOneById(1L));
        message.setMessageDate(LocalDateTime.now()); //cuva dva sata ranije, a na frontu dobro prikazuje
        messageRepository.save(message);
    }
}
