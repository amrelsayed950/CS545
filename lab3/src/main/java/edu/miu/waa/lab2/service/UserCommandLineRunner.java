package edu.miu.waa.lab2.service;

import edu.miu.waa.lab2.domain.Comment;
import edu.miu.waa.lab2.domain.Post;
import edu.miu.waa.lab2.domain.User;
import edu.miu.waa.lab2.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        setData();
    }
    private void setData() {
        Comment comment = new Comment("Hello comment");
        Comment comment2 = new Comment("Hello comment2");
        Comment comment3 = new Comment("Hello comment3");
        Comment comment4 = new Comment("Hello comment4");
        Comment comment5 = new Comment("Hello comment5");
        Comment comment6 = new Comment("Hello comment6");
        Comment comment7 = new Comment("Hello comment7");
        Comment comment8 = new Comment("Hello comment8");

        Post post = new Post("title","content","author", List.of(comment,comment2,comment3,comment4));
        Post post2 = new Post("title","content2","author2", List.of(comment5,comment6));
        Post post3 = new Post("title3","content3","author3", List.of(comment7,comment8));

        comment.setPost(post);
        comment2.setPost(post);
        comment3.setPost(post);
        comment4.setPost(post);
        comment5.setPost(post2);
        comment6.setPost(post2);
        comment7.setPost(post3);
        comment8.setPost(post3);


        User postUser = new User("Amr", List.of(post,post3));
        userRepository.save(postUser);

        User postUser2 = new User("ahmed", List.of(post2));
        userRepository.save(postUser2);


        User postUser3 = new User("elsayed", Collections.emptyList());
        userRepository.save(postUser3);
    }
}
