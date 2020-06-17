package com.xml.controller;

import com.xml.dto.CommentDto;
import com.xml.mapper.CommentDtoMapper;
import com.xml.model.Comment;
import com.xml.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentDtoMapper commentDtoMapper;

    @GetMapping(value = "/{adId}")
    public ResponseEntity<?> getAll(@PathVariable("adId") Long adId) {
        try {
            List<CommentDto> commentDtos = this.commentService.getAll(adId).stream()
                    .map(commentDtoMapper::toDto).collect(Collectors.toList());
            System.out.println("komentar: "+commentDtos.get(0).getComment());
            return new ResponseEntity<>(commentDtos, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("......");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(value = "/reply")
    public ResponseEntity<?> sendReply(@Valid @RequestBody CommentDto commentDto) {
        try {

            this.commentService.sendReply(commentDto.getId(),commentDto.getReply());
            System.out.println("usao1");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("usao2");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
