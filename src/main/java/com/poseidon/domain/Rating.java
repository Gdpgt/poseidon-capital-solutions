package com.poseidon.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

}
