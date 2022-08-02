package com.sparta.springcore.repository;

import com.sparta.springcore.model.ArticleEntity;
import com.sparta.springcore.model.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

}
