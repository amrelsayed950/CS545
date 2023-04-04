package edu.miu.waa.lab1.service;

import edu.miu.waa.lab1.domain.Post;
import edu.miu.waa.lab1.domain.dto.PostDto;
import edu.miu.waa.lab1.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<Post> getAllPosts() {
        return postRepository.getAllPosts();
    }

    @Override
    public Post getPostById(long id) {
        return postRepository.getById(id);
    }

    //without modelMapper ----

//    @Override
//    public PostDto getPostByIdUsingDto(long id) {
//        var post = postRepository.getById(id);
//        PostDto p = new PostDto();
//        p.setId(post.getId());
//        p.setTitle(post.getTitle());
//        p.setContent(post.getContent());
//        p.setAuthor(post.getAuthor());
//        return p;
//    }

    //with model Mapper
    @Override
    public PostDto getPostByIdUsingDto(long id) {
        return modelMapper.map(postRepository.getById(id), PostDto.class);
    }

    @Override
    public void addNewPost(Post p) {
        postRepository.addNewPost(p);
    }

    @Override
    public void deletePost(long id) {
        postRepository.deletePost(id);
    }

    @Override
    public void updatePost(long id, Post p) {
        postRepository.updatePost(id, p);
    }

    @Override
    public List<Post> getPostByAuthor(String author) {
        List<Post> allPosts = new ArrayList<>(getAllPosts());
        return allPosts.stream()
                .filter(p -> p.getAuthor().equals(author)).collect(Collectors.toList());

    }
}
