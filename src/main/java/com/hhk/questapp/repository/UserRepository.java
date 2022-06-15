package com.hhk.questapp.repository;

import com.hhk.questapp.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
