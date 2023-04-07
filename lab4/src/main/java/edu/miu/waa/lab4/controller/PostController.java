package edu.miu.waa.lab4.controller;

import edu.miu.waa.lab4.domain.Post;
import edu.miu.waa.lab4.domain.dto.PostDto;
import edu.miu.waa.lab4.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    //for both posts/ and posts?filter=Tornado Warning in MidWest
    @GetMapping
    public List<PostDto> getPost(@RequestParam(value = "filter", required = false) String title){
        return title==null ? postService.findAll() : postService.getAllPostsMatchByTitle(title);
    }

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable("id") long id){
        return postService.getById(id);
    }

    //http
    @GetMapping("/getAllPostsByTitle/{t}")
    public List<PostDto> getAllPostsByTitle(@PathVariable("t") String title){
        //System.out.println(title);
        return postService.getAllPostsMatchByTitle(title);
    }

//    @GetMapping()// တူတာ၂ခုရှိလို့မရ
//    public List<PostDto> getAllPostsByTitleRP(@RequestParam("filter") String title){
//        return postService.getAllPostsMatchByTitle(title);
//    }

    //-----------------------------
    //RequestParam Demo
    //-----------------------------
//    @GetMapping("/demo")
//    public String printSomething(@RequestParam("filter") int price){//can do value=filer
//        return "" + price; //this is converting to string
//    }
    //test in postman GET > http://localhost:8080/api/v1/products/demo?filter=400
    //it will return 400, which is the param value passed

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPost(@RequestBody PostDto post){
        postService.addPost(post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("id") long id){
        postService.deletePost(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  void updatePost(@PathVariable("id") long id, @RequestBody Post p){
        postService.updatePost(id, p);
    }

}
