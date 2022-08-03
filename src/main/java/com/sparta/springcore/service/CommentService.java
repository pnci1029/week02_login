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
        String commentContent = dto.getCommentContent();

        CommentEntity data = new CommentEntity(commentContent, articleId, username);
        commentRepository.save(data);
    }

    @Transactional
    public void putComment(CommentDto dto, Long id, User user) {
        CommentEntity target = commentRepository.findByArticleEntityId(id).orElseThrow(
                () ->new NullPointerException("수정하려는 아이디가 없습니다")
        );

        if(!target.getUsername().equals(user.getUsername())){
            throw new NullPointerException("다른사용자는 수정할수없습니다");
        }
        target.update(dto);
        commentRepository.save(target);
    }

    public void deletecomment(Long articleid, Long commentid,User user) {
        CommentEntity target = commentRepository.findById(commentid).orElseThrow(
                () -> new NullPointerException("삭제하려는 댓글이 없습니다")
        );
//        if (!articleid.equals(commentid)) {
//            throw new NullPointerException("다른 사용자는삭제할수없습니다");
//        }
        if (!target.getUsername().equals(user.getUsername())) {
            throw new NullPointerException("다른 사용자는삭제할수없습니다");
        }

        commentRepository.deleteById(target.getId());

    }
}
