package edu.miu.waa.lab1.repository;

import edu.miu.waa.lab1.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class PostRepositoryImpl implements PostRepository {

    List<Post> posts = new ArrayList<>(
            Arrays.asList(
                    new Post(1, "Tornado Warning in IOWA", "Tornado Warning in IOWA will happen in fairfield", "Amr Elsayed"),
                    new Post(2, "Now In Android", "Exciting news for #AndroidDevs! ML Kit's Google Code Scanner is now generally available on Android! ", "Mustafa Mahmoud")
            ));

    @Override
    public List<Post> getAllPosts() {
        return posts;
    }

    @Override
    public Post getById(long id) {
        return posts
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addNewPost(Post p) {
        posts.add(p);
    }

    @Override
    public void deletePost(long id) {
        var post = posts.stream()
                .filter(p -> p.getId() == id)
                .findFirst().get();
        posts.remove(post);
    }

    @Override
    public void updatePost(long id, Post p) {
        Post post = getById(id);
        post.setTitle(p.getTitle());
        post.setAuthor(p.getAuthor());
        post.setContent(p.getContent());
    }


}
