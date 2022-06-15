package com.hhk.questapp.repository;

import com.hhk.questapp.entitiy.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository <Comment,Long>{
}
