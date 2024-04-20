package com.socialmedia.post_service.repo;
import com.socialmedia.post_service.collection.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    Optional<Comment> findByIdAndPostId(String commentId, String postId);
}

