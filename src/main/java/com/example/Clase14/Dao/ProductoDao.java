package com.example.Clase14.Dao;

import com.example.Clase14.Model.Cliente;
import com.example.Clase14.Model.Producto;

import java.util.List;


public interface ProductoDao {

    List<Producto> getProducto();

    void eliminar(Long id);
    void cargar(Producto producto);

}
