package edu.miu.waa.lab4.service;

import edu.miu.waa.lab4.domain.Comment;
import edu.miu.waa.lab4.domain.Post;
import edu.miu.waa.lab4.domain.dto.PostDto;
import edu.miu.waa.lab4.helper.ListMapper;
import edu.miu.waa.lab4.repository.PostRepository;
import edu.miu.waa.lab4.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepo;

    @Autowired
    UserRepository postUserRepo;

    @Autowired
    CommentService commentService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;

    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>)listMapperPostToDto.mapList((List<Post>) postRepo.findAll(), new PostDto());
    }

    @Override
    public PostDto getById(long id) {
        return  modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public void addPost(PostDto p) {
        // --- for join column data save ---
        Post newP = new Post();
        newP.setTitle(p.getTitle());
        newP.setAuthor(p.getAuthor());
        newP.setContent(p.getContent());
        var user = postUserRepo.findById(p.getUserId());
        newP.setPostUser(user);
        postRepo.save(newP);
    }

    @Override
    public void deletePost(long id) {
        postRepo.deleteById(id);

    }

    public List<Comment> getAllCommentsByPostId(long id){
        return postRepo.findById(id).getComments();
    }

    @Override
    public void updatePost(long id, Post p) {
        if(postRepo.existsById(id)){
            postRepo.save(p);
        }
    }

    @Override
    //must return PostDto, with Post - data return are all loop in user
    public List<PostDto> getAllPostsMatchByTitle(String title) {
        return (List<PostDto>)listMapperPostToDto.mapList(postRepo.getAllPostsByTitle(title), new PostDto());
    }

}

