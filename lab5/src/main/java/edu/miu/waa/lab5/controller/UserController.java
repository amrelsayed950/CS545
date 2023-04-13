package edu.miu.waa.lab5.controller;

import edu.miu.waa.lab5.domain.PostUser;
import edu.miu.waa.lab5.domain.dto.CommentDto;
import edu.miu.waa.lab5.domain.dto.PostDto;
import edu.miu.waa.lab5.domain.dto.UserDto;
import edu.miu.waa.lab5.service.PostUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    PostUserService postUserService;

    @GetMapping
    public List<UserDto> getPostUser(){
        //make fake exception to test aspect log - @AfterThrowing, @Around
//        int[] arr = new int[3];
//        System.out.println(arr[5]);
        return postUserService.findAll();
    }
    @GetMapping("/{id}")
    public UserDto getPostUserById(@PathVariable("id") long id) {return  postUserService.getById(id);}

    @GetMapping("{id}/posts")
    public List<PostDto> getAllPostsByUserId(@PathVariable("id") long id)
    {
        return postUserService.getAllPostsByUserId(id);
    }

    @GetMapping("/usersWithMoreThanOnePosts")
    public List<UserDto> findUsersWithMoreThanOnePost(){
        return postUserService.findUsersWithMoreThanOnePost();
    }

    @GetMapping("/usersWithMoreThanNPosts/{num}")
    public List<UserDto> findUsersWithMoreThanNPosts(@PathVariable("num") int num){
        return postUserService.findUsersWithMoreThanNPosts(num);
    }

    @GetMapping("/usersWhoMadePostsByTitle/{title}")
    public List<UserDto> findUsersWhoMadePostsByTitle(@PathVariable("title") String title){
        return postUserService.findUsersWhoMadePostsByTitle(title);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPostUser(@RequestBody PostUser postUser){
        postUserService.addUser(postUser);}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePostUser(@PathVariable("id") long id, @RequestBody PostUser postUser){
        postUserService.updateUser(id, postUser);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePostUser(@PathVariable("id") long id){
        postUserService.deleteUser(id);
    }


    @GetMapping("{userId}/posts/{postId}/comments/{commentId}/")
    public CommentDto getCommentByIdFromPostByIdFromUserById(@PathVariable("userId") long userId, @PathVariable("postId") long postId, @PathVariable("commentId") long commentId)
    {

        return postUserService.getCommentByIdFromPostByIdFromUserById(userId,postId,commentId);
    }


}
