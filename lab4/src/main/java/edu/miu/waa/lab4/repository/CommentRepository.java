package edu.miu.waa.lab4.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import edu.miu.waa.lab4.domain.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findAll();
}

