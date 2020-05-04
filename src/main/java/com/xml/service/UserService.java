package com.xml.service;

import com.xml.model.User;

public interface UserService {
    User getUser(Long id);

    void saveUser(User user);
}
