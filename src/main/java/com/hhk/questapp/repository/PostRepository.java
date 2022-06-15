package com.hhk.questapp.repository;

import com.hhk.questapp.entitiy.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Like,Long> {
}
