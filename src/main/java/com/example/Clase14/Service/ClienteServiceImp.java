package com.example.Clase14.Service;

import org.springframework.stereotype.Service;
import com.example.Clase14.Entity.Cliente;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService {

    @Override
    public List<Cliente>  listarCliente(){
        List<Cliente> clientes = new ArrayList<>();

        Cliente cliente1 = new Cliente();
        cliente1.setIdCliente(1);
        cliente1.setNombre("Roma");
        cliente1.setDireccion("Direccion");
        cliente1.setMail("mail");

        clientes.add(cliente1);
        return clientes;
    }


}
