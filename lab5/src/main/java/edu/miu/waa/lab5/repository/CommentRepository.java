package edu.miu.waa.lab5.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import edu.miu.waa.lab5.domain.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findAll();
}

