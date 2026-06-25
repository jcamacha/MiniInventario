package com.ipn.mx.miniinventario.core;

import com.ipn.mx.miniinventario.core.entidades.Categoria;
import com.ipn.mx.miniinventario.core.entidades.Producto;
import com.ipn.mx.miniinventario.core.features.categoria.repository.CategoriaDAO;
import com.ipn.mx.miniinventario.core.features.producto.repository.ProductoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private CategoriaDAO categoriaDAO;

    @Autowired
    private ProductoDAO productoDAO;

    @Override
    public void run(String... args) {
        if (categoriaDAO.count() > 0) {
            return; // Ya hay datos
        }

        // Categorías
        Categoria electronicos = new Categoria();
        electronicos.setNombreCategoria("Electrónicos");
        electronicos.setDescripcionCategoria("Dispositivos y gadgets electrónicos");
        electronicos.setCreateAt(LocalDate.now());
        categoriaDAO.save(electronicos);

        Categoria oficina = new Categoria();
        oficina.setNombreCategoria("Oficina");
        oficina.setDescripcionCategoria("Material y mobiliario de oficina");
        oficina.setCreateAt(LocalDate.now());
        categoriaDAO.save(oficina);

        Categoria alimentos = new Categoria();
        alimentos.setNombreCategoria("Alimentos");
        alimentos.setDescripcionCategoria("Productos de despensa y bebidas");
        alimentos.setCreateAt(LocalDate.now());
        categoriaDAO.save(alimentos);

        Categoria limpieza = new Categoria();
        limpieza.setNombreCategoria("Limpieza");
        limpieza.setDescripcionCategoria("Artículos de limpieza e higiene");
        limpieza.setCreateAt(LocalDate.now());
        categoriaDAO.save(limpieza);

        // Productos
        Producto p1 = new Producto();
        p1.setNombreProducto("Monitor LED 24\"");
        p1.setDescripcionProducto("Monitor LG Full HD 24 pulgadas");
        p1.setPrecioProducto(3200.00);
        p1.setExistencia(15);
        p1.setIdCategoria(electronicos);
        p1.setCreateAt(LocalDate.now());
        productoDAO.save(p1);

        Producto p2 = new Producto();
        p2.setNombreProducto("Teclado mecánico");
        p2.setDescripcionProducto("Teclado Redragon switches azules");
        p2.setPrecioProducto(850.00);
        p2.setExistencia(30);
        p2.setIdCategoria(electronicos);
        p2.setCreateAt(LocalDate.now());
        productoDAO.save(p2);

        Producto p3 = new Producto();
        p3.setNombreProducto("Silla ejecutiva");
        p3.setDescripcionProducto("Silla ergonómica con soporte lumbar");
        p3.setPrecioProducto(4500.00);
        p3.setExistencia(8);
        p3.setIdCategoria(oficina);
        p3.setCreateAt(LocalDate.now());
        productoDAO.save(p3);

        Producto p4 = new Producto();
        p4.setNombreProducto("Resma de papel bond");
        p4.setDescripcionProducto("Papel tamaño carta 500 hojas");
        p4.setPrecioProducto(120.00);
        p4.setExistencia(100);
        p4.setIdCategoria(oficina);
        p4.setCreateAt(LocalDate.now());
        productoDAO.save(p4);

        Producto p5 = new Producto();
        p5.setNombreProducto("Café molido 500g");
        p5.setDescripcionProducto("Café orgánico de Chiapas");
        p5.setPrecioProducto(180.00);
        p5.setExistencia(50);
        p5.setIdCategoria(alimentos);
        p5.setCreateAt(LocalDate.now());
        productoDAO.save(p5);

        Producto p6 = new Producto();
        p6.setNombreProducto("Aceite de oliva 1L");
        p6.setDescripcionProducto("Aceite de oliva virgen extra español");
        p6.setPrecioProducto(250.00);
        p6.setExistencia(40);
        p6.setIdCategoria(alimentos);
        p6.setCreateAt(LocalDate.now());
        productoDAO.save(p6);

        Producto p7 = new Producto();
        p7.setNombreProducto("Jabón líquido 5L");
        p7.setDescripcionProducto("Jabón multiusos para trastes y superficies");
        p7.setPrecioProducto(95.00);
        p7.setExistencia(60);
        p7.setIdCategoria(limpieza);
        p7.setCreateAt(LocalDate.now());
        productoDAO.save(p7);

        Producto p8 = new Producto();
        p8.setNombreProducto("Cloro galón");
        p8.setDescripcionProducto("Cloro concentrado para desinfección");
        p8.setPrecioProducto(45.00);
        p8.setExistencia(80);
        p8.setIdCategoria(limpieza);
        p8.setCreateAt(LocalDate.now());
        productoDAO.save(p8);

        System.out.println("=== Datos de ejemplo cargados: 4 categorías, 8 productos ===");
    }
}
