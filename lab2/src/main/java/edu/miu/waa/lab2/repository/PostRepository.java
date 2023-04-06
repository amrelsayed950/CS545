package edu.miu.waa.lab2.repository;

import edu.miu.waa.lab2.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findAll();
}
