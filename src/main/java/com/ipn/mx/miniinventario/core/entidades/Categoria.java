package com.ipn.mx.miniinventario.core.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Categoria")
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idCategoria;

    @Size(min = 4, max = 50)
    @Column(length = 50, nullable = false)
    private String nombreCategoria;

    @Column(length = 100, nullable = false)
    private String descripcionCategoria;

    @Column(name = "create_at", nullable = true)
    private LocalDate createAt;

    @OneToMany(mappedBy = "idCategoria", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Producto> productos = new HashSet<Producto>();
}

