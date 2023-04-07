package edu.miu.waa.lab4.controller;

import edu.miu.waa.lab4.domain.dto.CommentDto;
import edu.miu.waa.lab4.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
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
