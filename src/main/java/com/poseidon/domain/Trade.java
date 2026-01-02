package com.poseidon.domain;

import java.sql.Timestamp;

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
@Table(name = "trade")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer tradeId;

    @NotBlank(message = "Account is mandatory")
    String account;

    @NotBlank(message = "Type is mandatory")
    String type;

    @NotNull(message = "Buy quantity is mandatory")
    @Positive(message = "Buy quantity must be positive")
    @Digits(integer = 9, fraction = 0, message = "Buy quantity must be a valid number")
    Double buyQuantity;

    @Positive(message = "Sell quantity must be positive")
    @Digits(integer = 9, fraction = 0, message = "Sell quantity must be a valid number")
    Double sellQuantity;

    @Positive(message = "Buy price must be positive")
    @Digits(integer = 10, fraction = 2, message = "Buy price must be a valid number")
    Double buyPrice;

    @Positive(message = "Sell price must be positive")
    @Digits(integer = 10, fraction = 2, message = "Sell price must be a valid number")
    Double sellPrice;

    Timestamp tradeDate;

    String security;

    String status;

    String trader;

    String benchmark;

    String book;

    String creationName;

    Timestamp creationDate;

    String revisionName;

    Timestamp revisionDate;

    String dealName;

    String dealType;

    String sourceListId;

    String side;

}
