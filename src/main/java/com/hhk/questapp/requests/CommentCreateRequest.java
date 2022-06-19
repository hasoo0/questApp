package com.hhk.questapp.requests;

import lombok.Data;

@Data
public class CommentCreateRequest {

    Long id;
    Long kullaniciId;
    Long postId;
    String text;
}
