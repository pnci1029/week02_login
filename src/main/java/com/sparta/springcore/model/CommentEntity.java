package com.sparta.springcore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentid;

    @Column(nullable = false)
    private String commentContent;

    @Column(nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "ARTICLE_ENTITY_ID")
    private ArticleEntity articleEntity;

//    @ManyToOne()
//    private User user;



    public CommentEntity(String commentContent, ArticleEntity articleEntity, String username) {
        this.commentContent = commentContent;
        this.articleEntity = articleEntity;
        this.username = username;
    }


//    public CommentEntity(String commentContent, String username) {
//        this.commentContent = commentContent;
//    }
}
