package com.sparta.springcore.repository;

import com.sparta.springcore.model.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
