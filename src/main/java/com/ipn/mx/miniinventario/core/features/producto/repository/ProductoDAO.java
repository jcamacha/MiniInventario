package com.ipn.mx.miniinventario.core.features.producto.repository;

import com.ipn.mx.miniinventario.core.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoDAO extends JpaRepository<Producto, Long>{

    @Modifying
    @Query("DELETE FROM Producto p WHERE p.idCategoria.idCategoria = :categoriaId")
    void deleteByCategoriaId(@Param("categoriaId") Long categoriaId);
}
