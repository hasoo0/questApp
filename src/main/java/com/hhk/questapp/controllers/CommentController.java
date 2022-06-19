package com.hhk.questapp.controllers;


import com.hhk.questapp.entitiy.Comment;
import com.hhk.questapp.entitiy.Post;
import com.hhk.questapp.requests.PostCreateResquest;
import com.hhk.questapp.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    

    @GetMapping("/{commentId}")
    public  Comment getOneComment(@PathVariable Long commentId){
        return commentService.getOneCommentById(commentId);
    }


}
