package com.example.Clase14.Controller;

import com.example.Clase14.Dao.ProductoDao;
import com.example.Clase14.Model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoDao productoDao;

    @RequestMapping(value="api/producto")
    public List<Producto> getProducto(){
        List<Producto> user= productoDao.getProducto();
        return user;
}

    @RequestMapping (value = "api/producto/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
        productoDao.eliminar(id);
    }

    @RequestMapping(value="api/producto", method = RequestMethod.POST)
    public void cargarProducto(@RequestBody Producto producto){
        productoDao.cargar(producto);
    }
}
