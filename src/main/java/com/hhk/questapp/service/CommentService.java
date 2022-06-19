package com.hhk.questapp.service;

import com.hhk.questapp.entitiy.Comment;
import com.hhk.questapp.entitiy.Kullanici;
import com.hhk.questapp.entitiy.Post;
import com.hhk.questapp.repository.CommentRepository;

import com.hhk.questapp.requests.CommentCreateRequest;

import com.hhk.questapp.requests.CommentUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private  KullaniciService kullaniciService;
    private PostService postService;


    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAllCommentsWithParam(Optional<Long> kullaniciId, Optional<Long> postId ) {
        if (kullaniciId.isPresent() && postId.isPresent()) {
            return commentRepository.findByKullaniciIdAndPostId(kullaniciId.get(),postId.get());
        }else if (kullaniciId.isPresent()){
            return commentRepository.findByKullaniciId(kullaniciId.get());
        }else if (postId.isPresent()){
            return commentRepository.findByPostId(postId.get());
        }else
            return commentRepository.findAll();

    }


    public Comment getOneCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createOneComment(CommentCreateRequest request) {
        Kullanici kullanici = kullaniciService.getOneKullaniciById(request.getKullaniciId());
        Post post = postService.getOnePostById(request.getPostId());
        if (kullanici != null && post != null){
            Comment commentToSave = new Comment();
            commentToSave.setId(request.getId());
            commentToSave.setPost(post);
            commentToSave.setKullanici(kullanici);
            commentToSave.setText(request.getText());
            return commentRepository.save(commentToSave);
        }else
            return null;
    }

    public Comment updateOneCommentById(Long commentId, CommentUpdateRequest request) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()){
            Comment commentToUpdate = comment.get();
            commentToUpdate.setText(request.getText());
           return commentRepository.save(commentToUpdate);
        }else
            return null;
    }

    public void deleteOneCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
