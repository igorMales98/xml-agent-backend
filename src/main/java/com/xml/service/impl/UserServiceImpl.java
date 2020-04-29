package com.xml.service.impl;

import com.xml.model.User;
import com.xml.repository.UserRepository;
import com.xml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return this.userRepository.getOne(id);
    }
}
