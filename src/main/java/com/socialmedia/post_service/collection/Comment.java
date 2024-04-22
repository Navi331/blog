package com.socialmedia.post_service.collection;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
@Data
public class Comment {
    @Id
    private String id;
    private String content;

    @DBRef
    @JsonIgnore
    private Post post;
}

