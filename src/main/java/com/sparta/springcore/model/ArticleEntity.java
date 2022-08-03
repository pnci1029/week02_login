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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
                                                              //mapped by가  있으면 db에 컬럼이 안생김
    @OneToMany(mappedBy = "username",cascade = CascadeType.ALL)     // 부모객체가 삭제되면 자식도 삭제 아님말고
    private List<CommentEntity> commentEntity;

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
