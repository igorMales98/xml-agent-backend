package com.xml.dto;

import com.xml.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class CommentDto {

    private Long id;

    @NotNull(message = "Commenter cannot be null")
    private User commenter;

    @NotBlank(message = "Comment cannot be empty")
    private String comment;

    private String reply;


    public CommentDto() {
    }

    public Long getId() {
        return id;
    }

    public User getCommenter() {
        return commenter;
    }

    public String getComment() {
        return comment;
    }

    public String getReply() {
        return reply;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCommenter(User commenter) {
        this.commenter = commenter;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }


}
