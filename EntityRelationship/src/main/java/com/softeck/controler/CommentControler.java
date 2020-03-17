package com.softeck.controler;


import com.softeck.DTOs.PostDTO;
import com.softeck.exception.ResourceNotFoundException;
import com.softeck.model.Comment;
import com.softeck.model.Post;
import com.softeck.repository.CommentJPARepository;
import com.softeck.repository.PostJPARepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class CommentControler {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommentJPARepository commentJPARepository;


    @Autowired
    private PostJPARepository postJPARepository;


    @RequestMapping(method = RequestMethod.POST,value = "/commentInsertValues")
    public String add(@RequestBody PostDTO postDTO)
    {
        System.out.println(modelMapper.map(postDTO,Post.class));
        System.out.println(modelMapper.map(postDTO,Comment.class));
        Post post =modelMapper.map(postDTO,Post.class);
        Comment comment =  modelMapper.map(postDTO,Comment.class);

        Comment comment1 =  new Comment();
        Post post1 =  new Post(post.getId(),post.getTitle(),post.getDescription(),post.getContent());
        comment1.setPost(comment.getPost());
        comment1.setId(comment.getId());
        comment1.setTitle(comment.getTitle());

        postJPARepository.save(post1);
        commentJPARepository.save(comment);
        return "Post Successfull";
    }

   @GetMapping("posts/{id}/comments")
   public Page<Comment> getValues(@PathVariable int id, Pageable page)
   {
       return commentJPARepository.findByPostId(id,page);
   }

    @PostMapping("posts/{id}/comments")
    public @Valid Comment insertValues(@RequestBody @Valid final Comment comment, @PathVariable int id)
    {
       return postJPARepository.findById(id)
               .map(post -> {
                                comment.setPost(post);
                                return commentJPARepository.save(comment);
                            })
               .orElseThrow(()-> new ResourceNotFoundException("Post Id:" + id + "Not_Found"));
    }
}
