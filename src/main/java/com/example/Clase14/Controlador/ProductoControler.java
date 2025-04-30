package com.example.Clase14.Controlador;

import com.example.Clase14.Entity.Productos;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
public class ProductoControler {

    @RequestMapping(value="listar/productos")
    public List<Productos> listar_variosProductos() {

        List<Productos> productos = new ArrayList<>();

        Productos producto1 = new Productos();

        producto1.setIdProducto(1);
        producto1.setCategoria("Libro");
        producto1.setNombre("Señor de los anillos");
        producto1.setStock(5);
        producto1.setPrecio(3000);


        Productos producto2 = new Productos();

        producto2.setIdProducto(2);
        producto2.setCategoria("Libreria");
        producto2.setNombre("cartuchera roja");
        producto2.setStock(3);
        producto2.setPrecio(2000);

        productos.add(producto1);
        productos.add(producto2);


        return productos;

    }


}
