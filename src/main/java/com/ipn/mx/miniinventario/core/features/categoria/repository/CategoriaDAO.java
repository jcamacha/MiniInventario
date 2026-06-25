package com.ipn.mx.miniinventario.core.features.categoria.repository;

import com.ipn.mx.miniinventario.core.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaDAO extends JpaRepository<Categoria, Long> {

}
