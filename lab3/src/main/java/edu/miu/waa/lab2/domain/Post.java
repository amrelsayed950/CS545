package edu.miu.waa.lab2.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;
    private String author;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "id_user")
    private User postUser;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post", fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private List<Comment> comments;

    public Post(String title, String content, String author, List<Comment> comments) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments = comments;
    }
}
