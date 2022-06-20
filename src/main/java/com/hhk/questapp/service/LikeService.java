package com.hhk.questapp.service;


import com.hhk.questapp.entitiy.Kullanici;
import com.hhk.questapp.entitiy.Like;
import com.hhk.questapp.entitiy.Post;

import com.hhk.questapp.repository.LikeRepository;
import com.hhk.questapp.requests.LikeCreateRequest;
import com.hhk.questapp.response.LikeResponse;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LikeService {

    private LikeRepository likeRepository;
    private KullaniciService  kullaniciService;
    private PostService postService;

    public LikeService(LikeRepository likeRepository, KullaniciService kullaniciService, PostService postService) {
        this.likeRepository = likeRepository;
        this.kullaniciService = kullaniciService;
        this.postService = postService;
    }


    public List<LikeResponse> getAllLikesWithParam(Optional<Long> kullaniciId, Optional<Long> postId) {
        List<Like> list;
        if(kullaniciId.isPresent() && postId.isPresent()) {
            list = likeRepository.findByKullaniciIdAndPostId(kullaniciId.get(), postId.get());
        }else if(kullaniciId.isPresent()) {
            list = likeRepository.findByKullaniciId(kullaniciId.get());
        }else if(postId.isPresent()) {
            list = likeRepository.findByPostId(postId.get());
        }else
            list = likeRepository.findAll();
        return list.stream().map(like -> new LikeResponse(like)).collect(Collectors.toList());
    }

    public Like getOneLikeById(Long LikeId) {
        return likeRepository.findById(LikeId).orElse(null);
    }

    public Like createOneLike(LikeCreateRequest request) {
        Kullanici kullanici = kullaniciService.getOneKullaniciById(request.getKullaniciId());
        Post post = postService.getOnePostById(request.getPostId());
        if(kullanici != null && post != null) {
            Like likeToSave = new Like();
            likeToSave.setId(request.getId());
            likeToSave.setPost(post);
            likeToSave.setKullanici(kullanici);
            return likeRepository.save(likeToSave);
        }else
            return null;
    }

    public void deleteOneLikeById(Long likeId) {
        likeRepository.deleteById(likeId);
    }


}



