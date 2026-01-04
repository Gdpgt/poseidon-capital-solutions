package com.poseidon.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rulename")
@NoArgsConstructor
public class RuleName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public RuleName(String name, String description, String json, String template, String sql, String sqlPart) {
        this.name = name;
        this.description = description;
        this.json = json;
        this.template = template;
        this.sql = sql;
        this.sqlPart = sqlPart;
    }

}
