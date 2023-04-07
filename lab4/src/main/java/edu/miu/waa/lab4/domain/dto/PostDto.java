package edu.miu.waa.lab4.domain.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private long id;
    private String title;
    private String content;
    private String author;

    private long userId;
}
