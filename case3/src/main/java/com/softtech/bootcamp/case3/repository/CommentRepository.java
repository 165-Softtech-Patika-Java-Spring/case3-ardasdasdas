package com.softtech.bootcamp.case3.repository;

import com.softtech.bootcamp.case3.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByUserId(Long userId);
    List<Comment> findAllByProductId(Long productId);
}
