package edu.miu.waa.lab1.domain.dto;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private long id;
    private String title;
    private String content;
    private String author;
}

