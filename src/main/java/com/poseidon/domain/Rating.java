package com.poseidon.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rating")
@NoArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotBlank(message = "Moody's rating is mandatory")
    String moodysRating;

    @NotBlank(message = "SandP's rating is mandatory")
    String sandPRating;

    @NotBlank(message = "Fitch's rating is mandatory")
    String fitchRating;

    @NotNull(message = "The order number is mandatory")
    @Positive(message = "The order number must be positive")
    @Digits(integer = 9, fraction = 0, message = "The order number must be a valid number")
    int orderNumber;

    public Rating(String moodysRating, String sandPRating, String fitchRating, int orderNumber) {
        this.moodysRating = moodysRating;
        this.sandPRating = sandPRating;
        this.fitchRating = fitchRating;
        this.orderNumber = orderNumber;
    }

}
