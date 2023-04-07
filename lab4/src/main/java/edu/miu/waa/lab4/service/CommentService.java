package edu.miu.waa.lab4.service;

import edu.miu.waa.lab4.domain.dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> findAll();

    public CommentDto getById(long id);

    public void addComment (CommentDto c);

    public void deleteComment(long id);


}
