package com.socialmedia.post_service.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.socialmedia.post_service.collection.Comment;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

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
