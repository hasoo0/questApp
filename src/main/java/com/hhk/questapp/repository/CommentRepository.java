package com.hhk.questapp.repository;

import com.hhk.questapp.entitiy.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository <Comment,Long>{


    List<Comment> findByKullaniciId(Long kullaniciId);

    List<Comment> findByKullaniciIdAndPostId(Long kullaniciId,Long postId );

    List<Comment> findByPostId(Long postId);
}
