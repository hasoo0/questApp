package com.hhk.questapp.service;

import com.hhk.questapp.entitiy.Comment;
import com.hhk.questapp.repository.CommentRepository;
import com.hhk.questapp.repository.KullaniciRepository;
import com.hhk.questapp.repository.PostRepository;
import com.hhk.questapp.requests.PostCreateResquest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private CommentRepository commentRepository;


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
}
