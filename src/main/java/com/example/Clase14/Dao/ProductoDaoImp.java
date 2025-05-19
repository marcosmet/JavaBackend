package com.example.Clase14.Dao;

import com.example.Clase14.Model.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductoDaoImp implements ProductoDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Producto> getProducto() {
        String query = "from Producto";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        Producto producto = entityManager.find(Producto.class, id);
        entityManager.remove(producto);
    }

    @Override
    public void cargar(Producto producto) {
        entityManager.merge(producto);
    }
}
