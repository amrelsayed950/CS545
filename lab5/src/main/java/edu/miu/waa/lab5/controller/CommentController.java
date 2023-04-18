package edu.miu.waa.lab5.controller;

import edu.miu.waa.lab5.domain.dto.CommentDto;
import edu.miu.waa.lab5.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public List<CommentDto> getComment(){
        return commentService.findAll();
    }


    @GetMapping
    public List<CommentDto> getCommentByPostId(@PathVariable long id){
        return commentService.findByPostId(id);
    }



    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addComment(@RequestBody CommentDto c){
        commentService.addComment(c);
    }

}
