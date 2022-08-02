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
    private Long id;

    @Column(nullable = false)
    private String commentContent;

    @ManyToOne
    @JoinColumn(name = "Comment_User_name")
    private User user;


    public CommentEntity(String commentContent, User user) {
        this.commentContent = commentContent;
        this.user = user;
    }


    public CommentEntity(String commentContent, String username) {
        this.commentContent = commentContent;
    }
}
