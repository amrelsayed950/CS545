package edu.miu.waa.lab4.service;

import edu.miu.waa.lab4.domain.User;
import edu.miu.waa.lab4.domain.dto.CommentDto;
import edu.miu.waa.lab4.domain.dto.PostDto;
import edu.miu.waa.lab4.domain.dto.UserDto;
import java.util.List;



public interface UserService {
    List<UserDto> findAll();
    UserDto getById(long id);
    void addUser(User user);
    void deleteUser(long id);
    void updateUser(long id, User user);
    List<PostDto> getAllPostsByUserId(long id);
    List<UserDto> findUsersWithMoreThanOnePost();

    List<UserDto> findUsersWithMoreThanNPosts(int n);
    List<UserDto> findUsersWhoMadePostsByTitle(String title);
    CommentDto getCommentByIdFromPostByIdFromUserById(long userId, long postId, long commentId);
}
