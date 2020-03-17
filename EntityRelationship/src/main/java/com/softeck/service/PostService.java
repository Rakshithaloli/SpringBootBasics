package com.softeck.service;

import com.softeck.model.Post;
import com.softeck.repository.PostJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService  {

    @Autowired
    PostJPARepository postJPARepository;


    List<Post> posts=new ArrayList<>();

    public String add(@RequestBody List<Post> post)
    {
        post.stream().forEach(pos->{postJPARepository.save(pos);});
        return "Post Successfull";
    }

    public List<Post> findAll()
    {
        return postJPARepository.findAll();
    }

    public Post save(Post post) {
        return postJPARepository.save(post);
    }
}
