package com.hhk.questapp.controllers;


import com.hhk.questapp.entitiy.Post;
import com.hhk.questapp.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPost(@RequestParam Optional<Long> kullaniciId){
        return  postService.getAllPosts(kullaniciId);
    }
    @GetMapping("/{PostId}")
    public Post getOnePost(@PathVariable Long postId){
        return postService.getOnePostById(postId);
    }


}
