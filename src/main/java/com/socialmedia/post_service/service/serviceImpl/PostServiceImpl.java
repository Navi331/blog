package com.socialmedia.post_service.service.serviceImpl;

import com.socialmedia.post_service.collection.Post;
import com.socialmedia.post_service.payload.PostDto;
import com.socialmedia.post_service.repo.PostRepo;
import com.socialmedia.post_service.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<?> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        if(posts.isEmpty()){
            return Collections.singletonList("No posts found");
        }
        return posts.stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(String id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
           throw  new RuntimeException("Post not found with id: "+id); // Handle the case when the post with the given id is not found
        }
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        post = postRepository.save(post);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto updatePost(String id, PostDto postDTO) {
        Post existingPost = postRepository.findById(id).orElse(null);
        if (existingPost == null) {
            throw  new RuntimeException("Post not found with id: "+id);
        }
        // Update fields from DTO
        modelMapper.map(postDTO, existingPost);
        existingPost.setId(id); // Ensure ID is not changed
        existingPost = postRepository.save(existingPost);
        return modelMapper.map(existingPost, PostDto.class);
    }

    @Override
    public void deletePost(String id) {
        Optional<Post> byId = postRepository.findById(id);
        byId.orElseThrow(()->new RuntimeException("No such post found for id " + id));
        postRepository.deleteById(id);
    }
}
