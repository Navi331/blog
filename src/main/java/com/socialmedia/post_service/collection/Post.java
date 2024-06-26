package com.socialmedia.post_service.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "posts")
@Data
public class Post {
    @Id
    private String id;

    private String title;

    @Field(name = "content")
    private String content;

    private String author;

    private String category;

    private boolean published;

    @DBRef(lazy = false)
    private List<Comment> comments = new ArrayList<>();
}

