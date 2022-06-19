package com.hhk.questapp.service;


import com.hhk.questapp.entitiy.Kullanici;
import com.hhk.questapp.entitiy.Post;
import com.hhk.questapp.repository.PostRepository;
import com.hhk.questapp.requests.PostCreateResquest;
import com.hhk.questapp.requests.PostUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;
    private KullaniciService kullaniciService;

    public PostService(PostRepository postRepository,KullaniciService kullaniciService) {
        this.postRepository = postRepository;
        this.kullaniciService = kullaniciService;
    }

    public List<Post> getAllPosts(Optional<Long> kullaniciId) {
        if (kullaniciId.isPresent())
            return postRepository.findByKullaniciId(kullaniciId.get());
       return postRepository.findAll();
    }

    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(Post newPost) {
        return postRepository.save(newPost);
    }

    public Post createOnePost(PostCreateResquest newPostRequest) {
        Kullanici kullanici = kullaniciService.getOneKullaniciById(newPostRequest.getKullaniciAdi());
      if (kullanici == null)
          return null;
      Post toSave = new Post();
      toSave.setId(newPostRequest.getId());
      toSave.setText(newPostRequest.getText());
      toSave.setTitle(newPostRequest.getTitle());
      toSave.setKullanici(kullanici);
        return postRepository.save(toSave);

    }


    public void deleteOnePostById(Long postId) {
        postRepository.deleteById(postId);
    }

    public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            Post toUpdate = post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }
}
