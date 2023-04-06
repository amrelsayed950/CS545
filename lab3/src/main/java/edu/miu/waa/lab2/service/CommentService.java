package edu.miu.waa.lab2.service;

import edu.miu.waa.lab2.domain.dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> findAll();

    public CommentDto getById(long id);

    public void addComment (CommentDto c);

    public void deleteComment(long id);


}
