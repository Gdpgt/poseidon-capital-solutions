package com.poseidon.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "curvepoint")
public class CurvePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    int curveId;
    
    Timestamp asOfDate;
    
    Double term;
    
    Double value;
    
    Timestamp creationDate;

}
