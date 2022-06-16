package com.hhk.questapp.service;


import com.hhk.questapp.entitiy.Post;
import com.hhk.questapp.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts(Optional<Long> kullaniciId) {
        if (kullaniciId.isPresent())
            return postRepository.findByKullaniciId(kullaniciId.get());
       return postRepository.findAll();
    }

    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }
}
