package com.sparta.springcore.service;

import com.sparta.springcore.dto.CommentDto;
import com.sparta.springcore.model.ArticleEntity;
import com.sparta.springcore.model.CommentEntity;
import com.sparta.springcore.model.User;
import com.sparta.springcore.repository.ArticleRepository;
import com.sparta.springcore.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, ArticleRepository articleRepository) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
    }

    @Transactional
    public void showComment() {
        commentRepository.findAll();
    }

    @Transactional
    public void postComment(CommentDto dto, String username, Long id) {
        ArticleEntity articleId = articleRepository.findArticleIdById(id).orElseThrow(
                () -> new NullPointerException("아티클아이디가 없습니다")
        );
        Long result = articleId.getId();
        String commentContent = dto.getCommentContent();

        CommentEntity data = new CommentEntity(commentContent, articleId, username);
        commentRepository.save(data);
    }
}
