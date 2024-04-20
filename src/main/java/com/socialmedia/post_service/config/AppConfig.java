package com.socialmedia.post_service.config;

import com.socialmedia.post_service.collection.Post;
import com.socialmedia.post_service.payload.PostDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Post.class, PostDto.class)
                .addMapping(Post::getComments, PostDto::setComments);
        return new ModelMapper();
    }
}
