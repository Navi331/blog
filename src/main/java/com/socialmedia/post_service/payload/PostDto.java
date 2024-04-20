package com.socialmedia.post_service.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PostDto {
    private String id;

    @NotBlank(message = "title is required")
    private String title;

    private String content;

    private String author;

    private String category;

    private boolean published;

}
