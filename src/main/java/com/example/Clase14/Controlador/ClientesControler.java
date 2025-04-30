package com.example.Clase14.Controlador;

import com.example.Clase14.Entity.Cliente;
import com.example.Clase14.Service.ClienteService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="clientes")
public class ClientesControler {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarCliente(){
        return clienteService.listarCliente();
    }


}
