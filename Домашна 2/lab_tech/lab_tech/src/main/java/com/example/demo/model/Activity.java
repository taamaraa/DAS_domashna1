package com.example.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "[activities]")
@NoArgsConstructor
@AllArgsConstructor

public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Column(name = "type")
    private String type;

    @NotNull
    @Column(name = "carbon_impact")
    private Double carbonImpact;

    public void setId(Long id) {
        this.id = id;
    }
}
