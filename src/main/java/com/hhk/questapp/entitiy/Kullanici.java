package com.hhk.questapp.entitiy;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kullanici")
@Data
public class Kullanici {

    @Id
    Long id;
    String kullaniciName;
    String password;

}
