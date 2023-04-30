package com.blogapp.blogapp.service;

import com.blogapp.blogapp.payload.PostDto;
import com.blogapp.blogapp.payload.PostResponse;

import java.util.List;

public interface PostService {

     PostDto createPost(PostDto postDto);

     PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

     PostDto getPostById(long id);

     PostDto updatePostById(PostDto postDto, long id);

     void deletePostById(long id);
}
