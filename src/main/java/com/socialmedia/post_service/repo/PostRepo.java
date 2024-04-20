package com.socialmedia.post_service.repo;

import com.socialmedia.post_service.collection.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepo extends MongoRepository<Post, String> {

}
