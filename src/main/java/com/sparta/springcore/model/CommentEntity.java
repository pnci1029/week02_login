package com.sparta.springcore.model;

import com.sparta.springcore.dto.CommentDto;
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
    private Long id;

    @Column(nullable = false)
    private String commentContent;

    @Column(nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "ARTICLEENTITY_ID")
    private ArticleEntity articleEntity;

//    @ManyToOne()
//    private User user;



    public CommentEntity(String commentContent, ArticleEntity articleEntity, String username) {
        this.commentContent = commentContent;
        this.articleEntity = articleEntity;
        this.username = username;
    }

    public void update(CommentDto dto) {
        this.commentContent = dto.getCommentContent();
    }


//    public CommentEntity(String commentContent, String username) {
//        this.commentContent = commentContent;
//    }
}
