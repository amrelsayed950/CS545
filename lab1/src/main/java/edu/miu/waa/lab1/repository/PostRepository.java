package edu.miu.waa.lab1.repository;

import edu.miu.waa.lab1.domain.Post;
import java.util.List;

public interface PostRepository {
    List<Post> getAllPosts();
    public Post getById(long id);
    public void addNewPost(Post p);
    public void deletePost(long id);
    public void updatePost(long id, Post p);
}
