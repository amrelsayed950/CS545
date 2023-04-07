package edu.miu.waa.lab4.controller;

import edu.miu.waa.lab4.aspect.annotation.ExecutionTime;
import edu.miu.waa.lab4.domain.User;
import edu.miu.waa.lab4.domain.dto.CommentDto;
import edu.miu.waa.lab4.domain.dto.PostDto;
import edu.miu.waa.lab4.domain.dto.UserDto;
import edu.miu.waa.lab4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> getPostUser(){
        //make fake exception to test aspect log - @AfterThrowing, @Around
//        int[] arr = new int[3];
//        System.out.println(arr[5]);
        return userService.findAll();
    }
    @ExecutionTime
    @GetMapping("/{id}")
    public UserDto getPostUserById(@PathVariable("id") long id) {return  userService.getById(id);}

    @GetMapping("{id}/posts")
    public List<PostDto> getAllPostsByUserId(@PathVariable("id") long id)
    {
        return userService.getAllPostsByUserId(id);
    }

    @GetMapping("/usersWithMoreThanOnePosts")
    public List<UserDto> findUsersWithMoreThanOnePost(){
        return userService.findUsersWithMoreThanOnePost();
    }

    @GetMapping("/usersWithMoreThanNPosts/{num}")
    public List<UserDto> findUsersWithMoreThanNPosts(@PathVariable("num") int num){
        return userService.findUsersWithMoreThanNPosts(num);
    }

    @GetMapping("/usersWhoMadePostsByTitle/{title}")
    public List<UserDto> findUsersWhoMadePostsByTitle(@PathVariable("title") String title){
        return userService.findUsersWhoMadePostsByTitle(title);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPostUser(@RequestBody User user){userService.addUser(user);}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePostUser(@PathVariable("id") long id, @RequestBody User user){
        userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePostUser(@PathVariable("id") long id){
        userService.deleteUser(id);
    }


    @GetMapping("{userId}/posts/{postId}/comments/{commentId}/")
    public CommentDto getCommentByIdFromPostByIdFromUserById(@PathVariable("userId") long userId, @PathVariable("postId") long postId, @PathVariable("commentId") long commentId)
    {
        return userService.getCommentByIdFromPostByIdFromUserById(userId,postId,commentId);
    }


}
