package com.sparta.springcore.model;

import com.sparta.springcore.dto.ArticleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "ARTICLE_USER_ID", nullable = false)
    private User user;

//    @OneToMany
//    @JoinColumn
//    private List<CommentEntity> commentEntity;


    public ArticleEntity(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public void update(ArticleDto dto, User user) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.user = user;
    }
}
