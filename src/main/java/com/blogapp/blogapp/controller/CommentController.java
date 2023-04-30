package com.blogapp.blogapp.controller;

import com.blogapp.blogapp.payload.CommentDTO;
import com.blogapp.blogapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {
    @Autowired
    private CommentService commentService;
    //localhost:8080/api/posts/1/comments
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDTO> createComment(@PathVariable("postId") Long postId, @RequestBody CommentDTO commentDTO){
        CommentDTO dto = commentService.createComment(postId, commentDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

}
