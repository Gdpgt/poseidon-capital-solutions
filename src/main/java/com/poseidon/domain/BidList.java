package com.poseidon.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "bidlist")
public class BidList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    
    @Digits(integer = 10, fraction = 2, message = "The bid must be a valid number")
    @Positive(message = "The bid must be positive")
    Double bid;
    
    @Digits(integer = 10, fraction = 2, message = "The ask must be a valid number")
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

}
