package com.poseidon.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "bidlist")
@NoArgsConstructor
public class BidList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BidListId")
    Integer bidListId;

    @NotBlank(message = "The account is mandatory")
    String account;

    @NotBlank(message = "The type is mandatory")
    String type;

    @NotNull(message = "The bid quantity is mandatory")
    @Digits(integer = 9, fraction = 0, message = "Bid Quantity must be a valid number")
    @Positive(message = "The bid quantity must be positive")
    Double bidQuantity;
    
    @Digits(integer = 9, fraction = 0, message = "Ask Quantity must be a valid number")
    @Positive(message = "The ask quantity must be positive")
    Double askQuantity;
    
    @Digits(integer = 10, fraction = 0, message = "The bid must be a valid number")
    @Positive(message = "The bid must be positive")
    Double bid;
    
    @Digits(integer = 10, fraction = 0, message = "The ask must be a valid number")
    @Positive(message = "The ask must be positive")
    Double ask;
    
    String benchmark;
    
    Timestamp bidListDate;
    
    String commentary;
    
    String security;
    
    String status;
    
    String trader;
    
    String book;
    
    String creationName;
    
    Timestamp creationDate;
    
    String revisionName;
    
    Timestamp revisionDate;
    
    String dealName;
    
    String dealType;
    
    String sourceListId;
    
    String side;

    public BidList(String account, String type, Double bidQuantity) {
        this.account = account;
        this.type = type;
        this.bidQuantity = bidQuantity;
    }

}
