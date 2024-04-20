package com.socialmedia.blog.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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

}

