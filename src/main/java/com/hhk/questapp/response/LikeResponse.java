package com.hhk.questapp.response;

import com.hhk.questapp.entitiy.Like;
import lombok.Data;

@Data
public class LikeResponse {

    Long id;
    Long kullaniciId;
    Long postId;

    public LikeResponse(Like entity) {
        this.id = entity.getId();
        this.kullaniciId = entity.getKullanici().getId();
        this.postId = entity.getPost().getId();
    }
}
