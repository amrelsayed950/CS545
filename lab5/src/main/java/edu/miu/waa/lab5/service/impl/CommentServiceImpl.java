package edu.miu.waa.lab5.service.impl;

import edu.miu.waa.lab5.domain.Comment;
import edu.miu.waa.lab5.domain.dto.CommentDto;
import edu.miu.waa.lab5.helper.ListMapper;
import edu.miu.waa.lab5.repository.CommentRepository;
import edu.miu.waa.lab5.repository.PostRepository;
import edu.miu.waa.lab5.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Comment, CommentDto> listMapperCommentToDto;

    @Override
    public List<CommentDto> findAll() {
        return (List<CommentDto>) listMapperCommentToDto.mapList(commentRepository.findAll(), new CommentDto());
    }

    @Override
    public CommentDto getById(long id) {
        return null;
    }

    @Override
    public void addComment(CommentDto c) {
        Comment newCmt = new Comment();
        newCmt.setName(c.getName());
        var post = postRepository.findById(c.getPostId());
        newCmt.setPost(post);
        commentRepository.save(newCmt);
    }

    @Override
    public void deleteComment(long id) {
        if(commentRepository.existsById(id)){
            commentRepository.deleteById(id);
        }
    }

@Override
   public List<CommentDto> findByPostId(long id){
        return commentRepository.findAllByPostId(id);
    }
}
