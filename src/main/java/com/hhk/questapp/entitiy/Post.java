package com.hhk.questapp.entitiy;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post")
@Data
public class Post {

    @Id
    Long id;
    Long kullaniciId;
    String title;

}
