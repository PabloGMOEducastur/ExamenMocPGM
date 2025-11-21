package com.examenmocpgm.ExamenMocPGM.controller;

import com.examenmocpgm.ExamenMocPGM.entity.Producto;
import com.examenmocpgm.ExamenMocPGM.service.ProductoService;
import com.examenmocpgm.ExamenMocPGM.service.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductoController {



    private ProductoService productoService = new ProductoService() {
        @Override
        public List<Producto> findAllProductos() {
            return List.of();
        }

        @Override
        public Optional<Producto> findProducto(Long id) {
            return Optional.empty();
        }

        @Override
        public List<Producto> findByCategoria(String categoria) {
            return List.of();
        }

        @Override
        public List<Producto> findByPrecio(float precio) {
            return List.of();
        }

        @Override
        public Producto addProducto(Producto producto) {
            return null;
        }

        @Override
        public List<Producto> findByPrecioAndCategoria(float precio, String categoria) {
            return List.of();
        }

        @Override
        public void eliminarProductoById(Long productoId) {

        }

        @Override
        public Producto modificarProducto(Long productoId, Producto producto) {
            return null;
        }
    };

    @PostMapping(value = "/productos")
    public Producto addProducto(@RequestBody Producto producto) {
        return this.productoService.addProducto(producto);
    }

    @DeleteMapping(value = "/producto/{productoId}")
    public void deleteProducto(@PathVariable Long productoId) {
        this.productoService.eliminarProductoById(productoId);
    }

    @PutMapping(value = "/producto/{productoId}")
    public Producto modificarProducto(@PathVariable Long productoId, @RequestBody Producto producto) {
        return this.productoService.modificarProducto(productoId,producto);
    }

    @GetMapping(value = "/api")
    public List<Producto> getProductos(@RequestParam(defaultValue = "0.0") Float precio,
                                       @RequestParam(defaultValue = "") String categoria) {
        /*
            - Si no se indica ni precio ni categoría -> obtener todos los productos.
            - Si se indica el precio -> obtener los productos con ese precio.
            - Si se indica la categoria -> obtener los productos con esa categoria.
         */
        return this.productoService.findAllProductos();
    }

    @GetMapping(value = "/producto/{productoId}")
    public Optional<Producto> getProducto(@PathVariable Long productoId) {
        return this.productoService.findProducto(productoId);
    }
}