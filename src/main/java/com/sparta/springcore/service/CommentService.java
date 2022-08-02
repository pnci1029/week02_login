package com.sparta.springcore.service;

import com.sparta.springcore.dto.CommentDto;
import com.sparta.springcore.model.ArticleEntity;
import com.sparta.springcore.model.CommentEntity;
import com.sparta.springcore.model.User;
import com.sparta.springcore.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Transactional
    public void showComment() {
        commentRepository.findAll();
    }

    @Transactional
    public void postComment(CommentDto dto, User username) {
        String commentContent = dto.getCommentContent();

        CommentEntity data = new CommentEntity(commentContent, username);
        commentRepository.save(data);
    }
}
