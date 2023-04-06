package edu.miu.waa.lab2.service;


import edu.miu.waa.lab2.domain.Post;
import edu.miu.waa.lab2.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    public PostDto getById(long id);
    public void addPost(Post p);
    public void deletePost(long id);
    public void updatePost(long id, Post p);
    public List<Post> getPostByAuthor(String author);

    public List<PostDto> getAllPostsMatchByTitle(String title);
}
