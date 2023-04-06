package edu.miu.waa.lab2.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import edu.miu.waa.lab2.domain.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findAll();
}

