package com.socialmedia.blog.restController;

import com.socialmedia.blog.payload.PostDto;
import com.socialmedia.blog.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    // http://localhost:8080/api/posts
    @GetMapping
    public ResponseEntity<List<?>> getAllPosts() {
        List<?> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // http://localhost:8080/api/posts/1
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable String id) {
        PostDto post = postService.getPostById(id);
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    // http://localhost:8080/api/posts
    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto PostDto) {
        PostDto createdPost = postService.createPost(PostDto);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/posts/1
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable String id, @Valid @RequestBody PostDto PostDto) {
        PostDto updatedPost = postService.updatePost(id, PostDto);
        if (updatedPost == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    // http://localhost:8080/api/posts/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable String id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}