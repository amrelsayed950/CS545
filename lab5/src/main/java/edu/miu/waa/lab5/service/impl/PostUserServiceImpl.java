package edu.miu.waa.lab5.service.impl;

import edu.miu.waa.lab5.domain.PostUser;
import edu.miu.waa.lab5.domain.dto.PostDto;
import edu.miu.waa.lab5.domain.dto.UserDto;
import edu.miu.waa.lab5.helper.ListMapper;
import edu.miu.waa.lab5.repository.PostRepository;
import edu.miu.waa.lab5.repository.UserRepository;
import edu.miu.waa.lab5.service.PostUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.miu.waa.lab5.domain.*;
import edu.miu.waa.lab5.domain.dto.*;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PostUserServiceImpl implements PostUserService {

    @Autowired
    UserRepository postUserRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<PostUser, UserDto> listMapperUserToDto;
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<UserDto> findAll() {
        return (List<UserDto>)listMapperUserToDto.mapList(postUserRepo.findAll(), new UserDto());
    }

    @Override
    public UserDto getById(long id) {
        return modelMapper.map(postUserRepo.findById(id), UserDto.class);
    }

    @Override
    public void addUser(PostUser postUser) {
        postUserRepo.save(postUser);
    }

    @Override
    public void deleteUser(long id) {
        postUserRepo.deleteById(id);
    }

    @Override
    public void updateUser(long id, PostUser postUser) {
        if(postUserRepo.existsById(id)) {
            postUserRepo.save(postUser);
        }
    }

    @Override
    public List<PostDto> getAllPostsByUserId(long id) {
        return postUserRepo.findById(id).getPosts()
                .stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findUsersWithMoreThanOnePost() {
        return postUserRepo.findUsersWithMoreThanOnePost()
                .stream()
                .map(u -> modelMapper.map(u, UserDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public List<UserDto> findUsersWithMoreThanNPosts(int n) {
        return (List<UserDto>) listMapperUserToDto.mapList(postUserRepo.findUsersWithMoreThanNPosts(n), new UserDto());
    }

    @Override
    public List<UserDto> findUsersWhoMadePostsByTitle(String title) {
        System.out.println(title);
        return postRepository.getAllPostsByTitle(title).stream()
                .map(p -> modelMapper.map(p.getPostUser() , UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
     public CommentDto getCommentByIdFromPostByIdFromUserById(long userId, long postId, long commentId) {

        List<Post> posts = postRepository.getPostsByUserId(userId);
        Post post = posts.stream().filter(p -> p.getId() == postId).findFirst().get();

        return modelMapper.map(post.getComments().stream()
                .filter(c -> c.getId() == commentId).findFirst().get(), CommentDto.class);

    }
}
