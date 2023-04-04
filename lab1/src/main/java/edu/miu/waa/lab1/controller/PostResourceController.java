package edu.miu.waa.lab1.controller;

import edu.miu.waa.lab1.domain.Post;
import edu.miu.waa.lab1.domain.PostV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostResourceController {
    /*
     * Custom Header Versioning
     * http://localhost:8080/posts/header
     * In the request header set
     * X-API-VERSION=1
     */
    @GetMapping(value = "posts/header", headers = "X-API-VERSION=1")
    public Post headerV1(){ return new Post(1,"Post V1 Title", "Post V1 Content", "Post V1 Author");}

    @GetMapping(value = "posts/header", headers = "X-API-VERSION=2")
    public PostV2 headerV2(){ return new PostV2(1,"Post V2 Title", "Post V2 Content", "Post V2 Author");}
}
