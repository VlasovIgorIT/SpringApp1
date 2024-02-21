package com.example.springapp1.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Entity
@Table(name = "lenses")
public class Lens {
    @Id
    @Column
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column
    private String design;

    @Column
    private int index;


}
