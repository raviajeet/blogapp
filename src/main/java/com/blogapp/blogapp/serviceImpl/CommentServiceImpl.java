package com.blogapp.blogapp.serviceImpl;

import com.blogapp.blogapp.entities.Comment;
import com.blogapp.blogapp.entities.Post;
import com.blogapp.blogapp.exception.ResourceNotFound;
import com.blogapp.blogapp.payload.CommentDTO;
import com.blogapp.blogapp.repository.CommentRepository;
import com.blogapp.blogapp.repository.PostRepository;
import com.blogapp.blogapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public CommentDTO createComment(Long postId, CommentDTO commentDTO) {
        Comment comment = mapToEntity(commentDTO);
        Post post = postRepository.findById(postId).orElseThrow(()->new ResourceNotFound("Post","id",postId));
        comment.setPost(post);
        Comment newComment = commentRepository.save(comment);
        CommentDTO commentDTO1 = mapToDTO(newComment);

        return commentDTO1;
    }

    private CommentDTO mapToDTO(Comment newComment) {
        CommentDTO commentDTO=new CommentDTO();
        commentDTO.setId(newComment.getId());
        commentDTO.setBody(newComment.getBody());
        commentDTO.setEmail(newComment.getEmail());
        commentDTO.setName(newComment.getName());
        return  commentDTO;
    }

    Comment mapToEntity(CommentDTO commentDTO){
        Comment comment=new Comment();
        comment.setBody(commentDTO.getBody());
        comment.setEmail(commentDTO.getEmail());
        comment.setName(commentDTO.getName());
        return comment;

    }
}
