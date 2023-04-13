package edu.miu.waa.lab5.repository;

import edu.miu.waa.lab5.domain.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
   // List<PostDto> findAll();


    public Post findById(long id);

    @Query(value = "SELECT * FROM post p WHERE p.title = :title", nativeQuery = true)
    public List<Post> getAllPostsByTitle(String title);

    @Query(value = "SELECT * FROM post p WHERE p.id_user = :id", nativeQuery = true)
    public List<Post> getPostsByUserId(long id);
}
