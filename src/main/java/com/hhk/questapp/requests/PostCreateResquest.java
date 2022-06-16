package com.hhk.questapp.requests;


import lombok.Data;

@Data
public class PostCreateResquest {

    Long id;
    String text;
    String title;
    Long kullaniciAdi;
}
