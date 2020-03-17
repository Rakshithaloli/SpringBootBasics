package com.softeck.controler;

import com.softeck.model.Post;
import com.softeck.repository.CommentJPARepository;
import com.softeck.repository.PostJPARepository;
import com.softeck.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class PostControler  {

    @Autowired
    PostService postService;

    @RequestMapping(method = RequestMethod.POST,value = "/insert")
    public String addUser(@RequestBody Post post)
    {
       return postService.add((List<Post>) post);
    }


   @GetMapping("/getPosts")
    public List<Post> getPosts()
    {
        return postService.findAll();
    }


     @PostMapping("/posts")
    public Post insertPosts(@RequestBody Post post)
    {
        return postService.save(post);
    }
}
