package com.xml.service;

import com.xml.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAll(Long adId);

    void sendReply(Long id, String reply);
}
