package edu.miu.waa.lab1.service;


import edu.miu.waa.lab1.domain.Post;
import edu.miu.waa.lab1.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    public Post getPostById(long id);
    public PostDto getPostByIdUsingDto(long id);
    public void addNewPost(Post p);
    public void deletePost(long id);
    public void updatePost(long id, Post p);

    public List<Post> getPostByAuthor(String author);
}
