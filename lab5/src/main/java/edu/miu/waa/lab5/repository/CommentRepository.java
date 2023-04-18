package edu.miu.waa.lab5.repository;

import edu.miu.waa.lab5.domain.dto.CommentDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import edu.miu.waa.lab5.domain.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findAll();

    @Query(value = "select * from Comment  c where c.post.id=:id",nativeQuery = true)
    List<CommentDto> findAllByPostId(long id);
}

