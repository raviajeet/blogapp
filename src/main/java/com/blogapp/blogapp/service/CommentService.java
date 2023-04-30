package com.blogapp.blogapp.service;

import com.blogapp.blogapp.payload.CommentDTO;

public interface CommentService {
     CommentDTO createComment(Long postId, CommentDTO commentDTO);
}
