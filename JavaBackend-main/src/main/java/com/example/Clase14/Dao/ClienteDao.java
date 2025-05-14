package com.example.Clase14.Dao;

import com.example.Clase14.Model.Cliente;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ClienteDao {


    List<Cliente> getClientes();

    void eliminar(Long id);
    void registrar(Cliente cliente);
    boolean verificarCredenciales(Cliente cliente);


}
