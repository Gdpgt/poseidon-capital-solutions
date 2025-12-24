package com.poseidon.domain;

import java.sql.Timestamp;

import jakarta.persistence.*;
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

    String account;

    String type;

    Double buyQuantity;

    Double sellQuantity;

    Double buyPrice;

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
