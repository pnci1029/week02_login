package com.sparta.springcore.repository;

import com.sparta.springcore.dto.CommentDto;
import com.sparta.springcore.model.ArticleEntity;
import com.sparta.springcore.model.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import javax.xml.stream.events.Comment;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    Optional<CommentEntity> findByArticleEntityId(Long id);


}
