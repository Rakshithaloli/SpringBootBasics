package com.softeck.repository;

import com.softeck.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentJPARepository extends JpaRepository<Comment,Integer> {
    Page<Comment> findByPostId(int id, Pageable page);
}
