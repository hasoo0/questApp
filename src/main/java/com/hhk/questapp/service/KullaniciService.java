package com.hhk.questapp.service;

import com.hhk.questapp.entitiy.Kullanici;
import com.hhk.questapp.repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KullaniciService {

    @Autowired
    private KullaniciRepository kullaniciRepository;

    public KullaniciService(KullaniciRepository kullaniciRepository) {
        this.kullaniciRepository = kullaniciRepository;

    }

    public List<Kullanici> getAllKullanici() {
        return kullaniciRepository.findAll();
    }

    public Kullanici saveOneKullanici(Kullanici newKullanici) {
        return kullaniciRepository.save(newKullanici);
    }

    public Kullanici getOneKullanici(Long kullaniciId) {
        return kullaniciRepository.findById(kullaniciId).orElse(null);
    }

    public Kullanici updateOneKullanici(Long kullaniciId, Kullanici newKullanici) {

        Optional<Kullanici> kullanici = kullaniciRepository.findById(kullaniciId);

        if (kullanici.isPresent()) {
            Kullanici foundKullanici = kullanici.get();
            foundKullanici.setKullaniciName(newKullanici.getKullaniciName());
            foundKullanici.setPassword(newKullanici.getPassword());
            kullaniciRepository.save(foundKullanici);
            return foundKullanici;
        } else
            return null;
    }
    public void deleteById(Long kullaniciId) {
        kullaniciRepository.deleteById(kullaniciId);
    }
}
