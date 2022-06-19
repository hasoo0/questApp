package com.hhk.questapp.controllers;


import com.hhk.questapp.entitiy.Comment;
import com.hhk.questapp.entitiy.Post;
import com.hhk.questapp.requests.CommentCreateRequest;
import com.hhk.questapp.requests.CommentUpdateRequest;
import com.hhk.questapp.requests.PostCreateResquest;
import com.hhk.questapp.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletionException;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;


    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> kullaniciId ,@RequestParam Optional<Long> postId ) {
        return commentService.getAllCommentsWithParam(kullaniciId, postId);
    }

    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequest  request){
        return commentService.createOneComment(request);
    }

    @GetMapping("/{commentId}")
    public  Comment getOneComment(@PathVariable Long commentId){
        return commentService.getOneCommentById(commentId);
    }
    @PutMapping("/{commentId}")
    public Comment updateOneComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest request){
        return commentService.updateOneCommentById(commentId,request);
    }
    @DeleteMapping ("/commentId")
    public void deleteOneComment(@PathVariable Long commentId){
        commentService.deleteOneCommentById(commentId);
    }

}
