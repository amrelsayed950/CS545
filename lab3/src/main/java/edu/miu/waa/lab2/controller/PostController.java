package edu.miu.waa.lab2.controller;

import edu.miu.waa.lab2.domain.Post;
import edu.miu.waa.lab2.domain.dto.PostDto;
import edu.miu.waa.lab2.service.PostService;
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
    public List<Post> getAllPost(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable("id") long id){
        return postService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewPost(@RequestBody Post post){
        postService.addPost(post);
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

    @GetMapping("/getAllPostsByTitle/{t}")
    public List<PostDto> getAllPostsByTitle(@PathVariable("t") String title){
        //System.out.println(title);
        return postService.getAllPostsMatchByTitle(title);
    }

}
