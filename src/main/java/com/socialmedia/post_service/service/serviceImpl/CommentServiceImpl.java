package com.socialmedia.post_service.service.serviceImpl;
import com.socialmedia.post_service.collection.Comment;
import com.socialmedia.post_service.collection.Post;
import com.socialmedia.post_service.exception.ResourceNotFoundException;
import com.socialmedia.post_service.payload.CommentDto;
import com.socialmedia.post_service.repo.CommentRepository;
import com.socialmedia.post_service.repo.PostRepo;
import com.socialmedia.post_service.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {


    private final PostRepo postRepository;

    private final CommentRepository commentRepository;

    public CommentServiceImpl(PostRepo postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment addCommentToPost(String postId, Comment comment) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
        comment.setPost(post);
        return commentRepository.save(comment);
    }

    @Override
    public Comment getComment(String postId, String commentId) {
        // Assuming postId is needed to identify a comment uniquely
        return commentRepository.findByIdAndPostId(commentId, postId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
    }

    @Override
    public Comment updateComment(String postId, String commentId, Comment updatedComment) {
        Comment existingComment = getComment(postId, commentId);
        existingComment.setContent(updatedComment.getContent());
        return commentRepository.save(existingComment);
    }

    @Override
    public void deleteComment(String postId, String commentId) {
        Comment comment = getComment(postId, commentId);
        commentRepository.delete(comment);
    }
}

