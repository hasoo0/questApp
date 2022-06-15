package com.hhk.questapp.entitiy;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
@Data
public class Comment {

    @Id
    Long id;
    Long PostId;
    Long kullaniciId;


}
