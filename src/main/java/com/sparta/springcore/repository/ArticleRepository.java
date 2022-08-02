package com.sparta.springcore.repository;

import com.sparta.springcore.model.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    Optional<ArticleEntity> findArticleIdById(Long id);
}
