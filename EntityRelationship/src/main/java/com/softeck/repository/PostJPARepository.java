package com.softeck.repository;

import com.softeck.model.Comment;
import com.softeck.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJPARepository  extends JpaRepository<Post,Integer>{
}
