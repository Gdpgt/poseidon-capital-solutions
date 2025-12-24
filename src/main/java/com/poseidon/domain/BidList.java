package com.poseidon.domain;


import jakarta.persistence.*;
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

    String account; 

    String type;

    Double bidQuantity;
    
    Double askQuantity;
    
    Double bid;
    
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
