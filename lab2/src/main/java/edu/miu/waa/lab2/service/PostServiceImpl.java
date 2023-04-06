package edu.miu.waa.lab2.service;

import edu.miu.waa.lab2.domain.Post;
import edu.miu.waa.lab2.domain.dto.PostDto;
import edu.miu.waa.lab2.repository.PostRepository;
import edu.miu.waa.lab2.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepo;

    @Autowired
    UserRepository userRepo;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public PostDto getById(long id) {
        return  modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public void addPost(Post p) {
        Post newP = new Post();
        newP.setTitle(p.getTitle());
        newP.setContent(p.getContent());
        newP.setAuthor(p.getAuthor());
        var user = userRepo.findById(p.getId());
        newP.setPostUser(user);
        postRepo.save(newP);
    }

    @Override
    public void deletePost(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void updatePost(long id, Post p) {
        if(postRepo.existsById(id)){
            postRepo.save(p);
        }
    }


    @Override
    public List<Post> getPostByAuthor(String author) {
        List<Post> allPosts = new ArrayList<>(findAll());
        return allPosts.stream()
                .filter(p -> p.getAuthor().equals(author)).collect(Collectors.toList());

    }

}

