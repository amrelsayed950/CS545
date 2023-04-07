package edu.miu.waa.lab4.repository;

import edu.miu.waa.lab4.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();

    User findById(long id);

    @Query(value = "SELECT u.* FROM post_user u WHERE (SELECT COUNT(p.*) FROM POST p WHERE p.id_user=u.id)>1", nativeQuery = true)
    List<User> findUsersWithMoreThanOnePost();


    @Query(value = "SELECT u.* FROM post_user u WHERE (SELECT COUNT(p.*) FROM POST p WHERE p.id_user=u.id)>:n", nativeQuery = true)
    List<User> findUsersWithMoreThanNPosts(int n);


}
