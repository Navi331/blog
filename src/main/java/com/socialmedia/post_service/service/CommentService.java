package com.socialmedia.post_service.service;

import com.socialmedia.post_service.collection.Comment;
import com.socialmedia.post_service.payload.CommentDto;

import java.util.List;

public interface CommentService {
    Comment addCommentToPost(String postId, Comment comment);
    Comment getComment(String postId, String commentId);
    Comment updateComment(String postId, String commentId, Comment comment);
    void deleteComment(String postId, String commentId);
    List<Comment> findCommentsByPostId(String postId);
}
