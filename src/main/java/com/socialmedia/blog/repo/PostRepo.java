package com.socialmedia.blog.repo;

import com.socialmedia.blog.collection.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepo extends MongoRepository<Post, String> {

}
