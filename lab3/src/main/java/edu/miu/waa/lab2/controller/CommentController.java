package edu.miu.waa.lab2.controller;

import edu.miu.waa.lab2.domain.dto.CommentDto;
import edu.miu.waa.lab2.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public List<CommentDto> getComment(){
        return commentService.findAll();
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addComment(@RequestBody CommentDto c){
        commentService.addComment(c);
    }

}
