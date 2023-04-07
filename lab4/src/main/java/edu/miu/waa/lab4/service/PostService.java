package edu.miu.waa.lab4.service;


import edu.miu.waa.lab4.domain.Post;
import edu.miu.waa.lab4.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();
    public PostDto getById(long id);
    public void addPost(PostDto p);
    public void deletePost(long id);
    public void updatePost(long id, Post p);
    public List<PostDto> getAllPostsMatchByTitle(String title);
}
