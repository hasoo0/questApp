package com.hhk.questapp.repository;

import com.hhk.questapp.entitiy.Like;
import com.hhk.questapp.entitiy.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findByKullaniciId(Long kullaniciId);
}
