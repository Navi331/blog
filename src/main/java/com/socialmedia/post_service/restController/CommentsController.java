package com.socialmedia.post_service.restController;
import com.socialmedia.post_service.collection.Comment;
import com.socialmedia.post_service.payload.CommentDto;
import com.socialmedia.post_service.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
public class CommentsController {

    private final CommentService commentsService;

    public CommentsController(CommentService commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping
    public ResponseEntity<Comment> addCommentToPost(@PathVariable String postId, @RequestBody Comment comment) {
        Comment savedComment = commentsService.addCommentToPost(postId, comment);
        return ResponseEntity.ok(savedComment);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> getComment(@PathVariable String postId, @PathVariable String commentId) {
        Comment comment = commentsService.getComment(postId, commentId);
        return ResponseEntity.ok(comment);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable String postId, @PathVariable String commentId, @RequestBody Comment comment) {
        Comment updatedComment = commentsService.updateComment(postId, commentId, comment);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable String postId, @PathVariable String commentId) {
        commentsService.deleteComment(postId, commentId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<List<Comment>> findCommentsByPostId(@PathVariable String postId) {
        List<Comment> comments = commentsService.findCommentsByPostId(postId);
        return ResponseEntity.ok(comments);
    }
}


