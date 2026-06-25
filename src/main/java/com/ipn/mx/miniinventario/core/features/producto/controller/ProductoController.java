package com.ipn.mx.miniinventario.core.features.producto.controller;

import com.ipn.mx.miniinventario.core.entidades.Producto;
import com.ipn.mx.miniinventario.core.features.producto.service.ProductoService;
import com.ipn.mx.miniinventario.core.features.mail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @Autowired
    private EmailService emailService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> findAll() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Producto findById(@PathVariable Long id) {
        return productoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producto create(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto update(@PathVariable Long id, @RequestBody Producto producto) {
        Producto p = productoService.findById(id);
        if (p != null) {
            p.setNombreProducto(producto.getNombreProducto());
            p.setDescripcionProducto(producto.getDescripcionProducto());
            p.setExistencia(producto.getExistencia());
            p.setPrecioProducto(producto.getPrecioProducto());
            p.setCreateAt(producto.getCreateAt());
            p.setIdCategoria(producto.getIdCategoria());
            return productoService.save(p);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        productoService.deleteById(id);
    }
}
