package com.hhk.questapp.controllers;


import com.hhk.questapp.entitiy.Post;
import com.hhk.questapp.requests.PostCreateResquest;
import com.hhk.questapp.requests.PostUpdateRequest;
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
    public List<Post> getAllPost(@RequestParam Optional<Long> kullaniciId) {
        return postService.getAllPosts(kullaniciId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateResquest newPostRequest) {
        return postService.createOnePost(newPostRequest);
    }


    @GetMapping("/{PostId}")
    public Post getOnePost(@PathVariable Long postId) {
        return postService.getOnePostById(postId);
    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost) {
        return postService.updateOnePostById(postId, updatePost);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId){
        postService.deleteOnePostById(postId);
    }



}
