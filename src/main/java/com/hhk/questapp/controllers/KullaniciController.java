package com.hhk.questapp.controllers;

import com.hhk.questapp.entitiy.Kullanici;
import com.hhk.questapp.repository.KullaniciRepository;
import com.hhk.questapp.service.KullaniciService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kullanici")
public class KullaniciController {

    private KullaniciService kullaniciService;

    public KullaniciController(KullaniciService kullaniciService){

        this.kullaniciService = kullaniciService;
    }

        @GetMapping
        public List<Kullanici> getAllKullanici() {
            return kullaniciService.getAllKullanici();
        }

        @PostMapping
        public Kullanici createKullanici(@RequestBody Kullanici newKullanici){
        return kullaniciService.saveOneKullanici(newKullanici);
    }

        @GetMapping("/{kullaniciId}")
        public Kullanici getOneKullanici(@PathVariable Long kullaniciId){
        // custom exception ekle
        return kullaniciService.getOneKullaniciById(kullaniciId);
        }

        @PutMapping("/{kullaniciId}")
        public Kullanici updateOneKullanici(@PathVariable Long kullaniciId, @RequestBody Kullanici newKullanici) {
            return kullaniciService.updateOneKullanici(kullaniciId,newKullanici);

        }

        @DeleteMapping("/{kullaniciId}")
        public void  deleteOneKullanici(@PathVariable Long kullaniciId){
            kullaniciService.deleteById(kullaniciId);
        }
}
