package edu.miu.waa.lab5.service;

import edu.miu.waa.lab5.domain.PostUser;
import edu.miu.waa.lab5.domain.dto.CommentDto;
import edu.miu.waa.lab5.domain.dto.PostDto;
import edu.miu.waa.lab5.domain.dto.UserDto;
import java.util.List;



public interface PostUserService {
    List<UserDto> findAll();
    UserDto getById(long id);
    void addUser(PostUser postUser);
    void deleteUser(long id);
    void updateUser(long id, PostUser postUser);
    List<PostDto> getAllPostsByUserId(long id);
    List<UserDto> findUsersWithMoreThanOnePost();

    List<UserDto> findUsersWithMoreThanNPosts(int n);
    List<UserDto> findUsersWhoMadePostsByTitle(String title);
    CommentDto getCommentByIdFromPostByIdFromUserById(long userId, long postId, long commentId);
}
