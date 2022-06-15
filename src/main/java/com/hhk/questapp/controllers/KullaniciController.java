package com.hhk.questapp.controllers;

import com.hhk.questapp.entitiy.Kullanici;
import com.hhk.questapp.repository.KullaniciRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kullanici")
public class KullaniciController {

    private KullaniciRepository kullaniciRepository;

    public KullaniciController(KullaniciRepository kullaniciRepository){

        this.kullaniciRepository = kullaniciRepository;
    }

    @GetMapping
    public List<Kullanici> getAllUsers(){
        return kullaniciRepository.findAll();
    }

    @PostMapping
    public Kullanici createKullanici(@RequestBody Kullanici newKullanici){
        return kullaniciRepository.save(newKullanici);
    }

    @GetMapping("/{kullaniciId}")
        public Kullanici getOneKullanici(@PathVariable Long kullaniciId){
        // custom exception ekle
        return kullaniciRepository.findById(kullaniciId).orElse(null);
        }

        @PutMapping("/{kullaniciId}")
         public Kullanici updateOneKullanici(@PathVariable Long kullaniciId, @RequestBody Kullanici newKullanici) {
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

        @DeleteMapping("/{kullaniciId}")
    public void  deleteOneKullanici(@PathVariable Long kullaniciId){
        kullaniciRepository.deleteById(kullaniciId);
        }
}
