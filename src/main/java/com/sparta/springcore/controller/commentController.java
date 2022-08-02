package com.sparta.springcore.controller;

import com.sparta.springcore.dto.CommentDto;
import com.sparta.springcore.model.ArticleEntity;
import com.sparta.springcore.model.User;
import com.sparta.springcore.security.UserDetailsImpl;
import com.sparta.springcore.service.CommentService;
import com.sparta.springcore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class commentController {
    private CommentService commentService;

    @Autowired
    public commentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @GetMapping("/api/comment")
    public void getComment() {
        commentService.showComment();
    }

    @PostMapping("/api/comment")
    public void postComment(@RequestBody CommentDto dto,
                            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();

        ArticleEntity article = new ArticleEntity();
        commentService.postComment(dto, user);

    }
}
