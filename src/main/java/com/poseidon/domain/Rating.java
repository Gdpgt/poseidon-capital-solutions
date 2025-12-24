package com.poseidon.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String moodysRating;

    String sandPRating;

    String fitchRating;

    int orderNumber;

}
