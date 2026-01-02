package com.poseidon.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rulename")
public class RuleName {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @NotBlank(message = "Name is mandatory")
    String name;

    @NotBlank(message = "Description is mandatory")
    String description;

    @NotBlank(message = "Json is mandatory")
    String json;

    @NotBlank(message = "Template is mandatory")
    String template;

    @NotBlank(message = "SQL is mandatory")
    @Column(name = "sqlStr")
    String sql;

    @NotBlank(message = "SQL Part is mandatory")
    String sqlPart;

}
