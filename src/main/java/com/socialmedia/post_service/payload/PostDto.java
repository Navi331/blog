package com.socialmedia.post_service.payload;
import com.socialmedia.post_service.collection.Comment;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostDto {
    private String id;

    @NotBlank(message = "title is required")
    private String title;

    private String content;

    private String author;

    private String category;

    private boolean published;

    private List<Comment> comments = new ArrayList<>();
}
