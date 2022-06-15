package com.hhk.questapp.repository;

import com.hhk.questapp.entitiy.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KullaniciRepository extends JpaRepository<Kullanici,Long> {
}
