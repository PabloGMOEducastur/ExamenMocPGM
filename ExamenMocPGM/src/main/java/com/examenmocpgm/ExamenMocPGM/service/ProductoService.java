package com.examenmocpgm.ExamenMocPGM.service;

import com.examenmocpgm.ExamenMocPGM.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> findAllProductos();
    Optional<Producto> findProducto(Long id);
    List<Producto> findByCategoria(String categoria);
    List<Producto> findByPrecio(float precio);

    Producto addProducto(Producto producto);

    List<Producto> findByPrecioAndCategoria(float precio, String categoria);

    void eliminarProductoById(Long productoId);
    Producto modificarProducto(Long productoId, Producto producto);
}
