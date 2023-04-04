package edu.miu.waa.lab1.controller;

import edu.miu.waa.lab1.domain.Post;
import edu.miu.waa.lab1.domain.dto.PostDto;
import edu.miu.waa.lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable("id") long id){
        return postService.getPostByIdUsingDto(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewPost(@RequestBody Post post){
        postService.addNewPost(post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("id") long id){
        postService.deletePost(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  void updatePost(@PathVariable("id") long id, @RequestBody Post p){
        postService.updatePost(id, p);
    }



    /*
     http://localhost:8080/posts/filter?author=Amr
    */
    @GetMapping("/v2/filter")
    public List<Post> getPostById(@RequestParam("author") String author){
        return postService.getPostByAuthor(author);
    }
}
