package com.hbt.estructura.localizacion.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "estructuras")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estructura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estructura_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Estructura padreId;

}
