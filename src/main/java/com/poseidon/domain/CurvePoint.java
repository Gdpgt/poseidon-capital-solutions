package com.poseidon.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @NotNull(message = "The curve id is mandatory")
    @Positive(message = "The curve id must be positive")
    @Digits(integer = 10, fraction = 0, message = "The curve id must be a valid number")
    int curveId;
    
    Timestamp asOfDate;
    
    @NotNull(message = "The term is mandatory")
    @Positive(message = "The term must be positive")
    @Digits(integer = 10, fraction = 0, message = "The term must be a valid number")
    Double term;
    
    @NotNull(message = "The value is mandatory")
    @Positive(message = "The value must be positive")
    @Digits(integer = 10, fraction = 2, message = "The value must be a valid number")
    Double value;
    
    Timestamp creationDate;

}
