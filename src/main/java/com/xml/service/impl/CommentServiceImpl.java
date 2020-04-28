package com.xml.service.impl;

import com.xml.model.Comment;
import com.xml.model.User;
import com.xml.repository.CommentRepository;
import com.xml.repository.UserRepository;
import com.xml.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAll(Long adId) {
        List<Comment> allComments = commentRepository.getAllByAdvertisement_id(adId);
        List<Comment> approvedComments = new ArrayList<>();
        for (Comment comment : allComments) {
            if(comment.isApproved()) {
                approvedComments.add(comment);
            }
        }
        return approvedComments;
    }

    @Override
    public void sendReply(Long id, String reply) {
        System.out.println(reply);
        Comment comment = commentRepository.findOneById(id);
        comment.setReply(reply);
        commentRepository.save(comment);
    }

}
