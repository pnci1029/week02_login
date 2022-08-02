package com.sparta.springcore.controller;

import com.sparta.springcore.dto.ArticleDto;
import com.sparta.springcore.model.User;
import com.sparta.springcore.security.UserDetailsImpl;
import com.sparta.springcore.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping("/api/articles")
    public void articleGet() {
        articleService.showArticle();
    }

    @PostMapping("/api/articles")
    public void articlePost(@AuthenticationPrincipal UserDetailsImpl userDetails,
                            @RequestBody ArticleDto dto
    ) {
        User user = userDetails.getUser();
        articleService.postArticle(dto, user);
    }

    @PutMapping("/api/articles/{id}")
    public void articlePut(@PathVariable Long id,
                           @RequestBody ArticleDto dto,
                           @AuthenticationPrincipal UserDetailsImpl userDetails) {

        User user = userDetails.getUser();

        articleService.putArticle(dto, id, user);
    }
//          게시물 13
    @DeleteMapping("/api/articles/{id}")
    public void articleDelete(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }
}
