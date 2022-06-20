package com.hhk.questapp.requests;


import lombok.Data;

@Data
    public class LikeCreateRequest {

        Long id;
        Long kullaniciId;
        Long postId;

    }

