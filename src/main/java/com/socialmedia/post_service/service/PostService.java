package com.socialmedia.post_service.service;

import com.socialmedia.post_service.payload.PostDto;

import java.util.List;

public interface PostService {
    List<?> getAllPosts();
    PostDto getPostById(String id);
    PostDto createPost(PostDto postDTO);
    PostDto updatePost(String id, PostDto postDTO);
    void deletePost(String id);
}
