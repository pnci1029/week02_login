package com.sparta.springcore.service;

import com.sparta.springcore.dto.ArticleDto;
import com.sparta.springcore.model.ArticleEntity;
import com.sparta.springcore.model.User;
import com.sparta.springcore.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void showArticle() {
        articleRepository.findAll();
    }

    public void postArticle(ArticleDto dto, User  user) {
        String title = dto.getTitle();
        String content = dto.getContent();

        ArticleEntity data = new ArticleEntity(title, content, user);
        articleRepository.save(data);


    }

    public void putArticle(ArticleDto dto, Long id, User user) {
        ArticleEntity target = articleRepository.findById(id).orElseThrow(
                () -> new NullPointerException("수정하려는 아이디가 없습니다ㅓ")
        );
//        db에있는 유저아이디랑 수정하기위해 접속된  유저아이디가 다르면 수정불가
        String username = target.getUser().getUsername();
        String getUsername = user.getUsername();

        if (!username.equals(getUsername)) {
            throw new NullPointerException("수정하려는 아이디가 다릅니다");
        }
        target.update(dto, user);
        articleRepository.save(target);

    }
    @Transactional
    public void deleteArticle(Long id, User user) {
        ArticleEntity target= articleRepository.findById(id).orElseThrow(
                () -> new NullPointerException("삭제하려는 아이디가 없습니다")
        );
//        db에있는 유저아이디랑 삭제하기위해 접속된  유저아이디가 다르면 수정불가
        String username = user.getUsername();
        String getUsername = target.getUser().getUsername();
        if (username != getUsername) {
            throw new NullPointerException("삭제하려는 아이디가 다릅니다");
        }

        articleRepository.delete(target);
//        articleRepository.deleteById(id);
    }
}
